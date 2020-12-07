package cn.iotat.core.log;

import cn.iotat.core.http.BaseResponse;
import cn.iotat.core.http.HttpErrorCodeEnum;
import cn.iotat.core.http.exception.AbstractCustomizeException;
import cn.iotat.core.util.param.ParamUtil;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;

import java.util.Map;

/**
 * 日志配置操作的父类
 *
 * @author pang
 */
public abstract class AbstractLoggerAspectConfig {

    /**
     * 切点操作
     *
     * @param point 切点
     * @return 返回的结果
     */
    public abstract Object around(ProceedingJoinPoint point);

    /**
     * 打印日志
     *
     * @param LOG         普通日志
     * @param LOG_MONITOR 监控日志
     * @param point       切点
     * @return 切点执行的结果
     */
    protected Object printLog(final Logger LOG, final Logger LOG_MONITOR, ProceedingJoinPoint point) {
        long start = System.currentTimeMillis();
        // 类名
        String className = point.getSignature().getDeclaringTypeName();
        // 方法名
        String methodName = point.getSignature().getName();
        // 参数
        Map<String, Object> argsMap = ParamUtil.getArgsMap(point);
        // 结果
        Object result = null;
        try {
            result = point.proceed();
            LOG.info("{}#{},args={},result={}", className, methodName, JSON.toJSONString(argsMap), result);
        } catch (Throwable e) {
            LOG.error("{}#{},args={},exception={},message={}", className, methodName,
                    JSON.toJSONString(argsMap), e.getClass().getTypeName(), e.getMessage(), e);
            if (e instanceof AbstractCustomizeException) {
                return BaseResponse.error(((AbstractCustomizeException) e).getHttpErrorCodeEnum());
            }
            return BaseResponse.error(HttpErrorCodeEnum.UNKNOWN_ERROR);
        } finally {
            long time = System.currentTimeMillis() - start;
            LOG_MONITOR.info("{}#{}|{}", className, methodName, time);
        }
        return result;
    }
}
