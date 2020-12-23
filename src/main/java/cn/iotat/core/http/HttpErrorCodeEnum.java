package cn.iotat.core.http;

public enum HttpErrorCodeEnum {
    //=========== 用戶方错误(1xxx) ===========
    /**
     * 必填参数没有填写
     */
    REQUIRED_PARAM_NOT_FILL("1000", "some required params is not fill"),
    /**
     * 用戶未登錄
     */
    NOT_LOGIN("1001", "User is not logged in"),
    /**
     * 用戶無操作權限
     */
    PERMISSION_DENIED("1002", "user have no permission"),
    /**
     * 用户上传的Token的subject错误，即accessToken和refreshToken混乱
     */
    TOKEN_SUBJECT_NOT_MATCHED("1003","token type not matched"),
    //=========== 内部错误(2xxx) ===========
    /**
     * 未知錯誤
     */
    UNKNOWN_ERROR("2000","server have some unknown error"),
    /**
     * 生成用户ID错误
     */
    ID_GENERATOR_ERROR("2001","some unknown errors with generating id"),
    //=========== 网络错误(3xxx) ===========

    //=========== 业务错误(4xxx) ===========

    /**
     * 由于开关关闭导致访问失败
     */
    SOME_SWITCH_OFF("4000","switch is off"),

    ;

    HttpErrorCodeEnum(String errCode, String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    private String errMsg;

    private String errCode;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"errMsg\":\"")
                .append(errMsg).append('\"');
        sb.append(",\"errCode\":\"")
                .append(errCode).append('\"');
        sb.append('}');
        return sb.toString();
    }
    }
