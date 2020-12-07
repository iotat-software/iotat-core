package cn.iotat.core.http.exception;

import cn.iotat.core.http.HttpErrorCodeEnum;

public abstract class AbstractCustomizeException extends RuntimeException {
    private static final long serialVersionUID = 3628929808384532747L;

    private final HttpErrorCodeEnum httpErrorCodeEnum;

    public AbstractCustomizeException(HttpErrorCodeEnum httpErrorCodeEnum) {
        super(httpErrorCodeEnum.getErrMsg());
        this.httpErrorCodeEnum = httpErrorCodeEnum;
    }

    public AbstractCustomizeException(HttpErrorCodeEnum httpErrorCodeEnum, Throwable cause) {
        super(httpErrorCodeEnum.getErrMsg(), cause);
        this.httpErrorCodeEnum = httpErrorCodeEnum;
    }


    public HttpErrorCodeEnum getHttpErrorCodeEnum() {
        return httpErrorCodeEnum;
    }

}
