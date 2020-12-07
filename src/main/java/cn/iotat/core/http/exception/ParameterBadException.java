package cn.iotat.core.http.exception;

import cn.iotat.core.http.HttpErrorCodeEnum;

/**
 * 參數錯誤異常
 */
public class ParameterBadException extends AbstractCustomizeException{
    private static final long serialVersionUID = -4674688630841172192L;

    public ParameterBadException(HttpErrorCodeEnum httpErrorCodeEnum) {
        super(httpErrorCodeEnum);
    }

    public ParameterBadException(HttpErrorCodeEnum httpErrorCodeEnum, Throwable cause) {
        super(httpErrorCodeEnum, cause);
    }
}
