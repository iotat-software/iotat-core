package cn.iotat.core.http.exception;

import cn.iotat.core.http.HttpErrorCodeEnum;

/**
 * 沒有操作權限異常
 */
public class PermissionDeniedException extends AbstractCustomizeException {
    private static final long serialVersionUID = -3013184945032461162L;

    public PermissionDeniedException(HttpErrorCodeEnum httpErrorCodeEnum) {
        super(httpErrorCodeEnum);
    }

    public PermissionDeniedException(HttpErrorCodeEnum httpErrorCodeEnum, Throwable cause) {
        super(httpErrorCodeEnum, cause);
    }
}
