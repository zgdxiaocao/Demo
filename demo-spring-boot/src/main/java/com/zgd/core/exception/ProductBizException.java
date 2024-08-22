package com.zgd.core.exception;

/**
 * 业务类异常
 *
 * @author zgd
 */
public class ProductBizException extends BaseBizException {
    public ProductBizException(String errorMsg) {
        super(errorMsg);
    }

    public ProductBizException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ProductBizException(BaseErrorCodeEnum baseErrorCodeEnum) {
        super(baseErrorCodeEnum);
    }

    public ProductBizException(String errorCode, String errorMsg, Object... arguments) {
        super(errorCode, errorMsg, arguments);
    }

    public ProductBizException(BaseErrorCodeEnum baseErrorCodeEnum, Object... arguments) {
        super(baseErrorCodeEnum, arguments);
    }
}
