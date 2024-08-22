package com.zgd.core.exception;

/**
 * 异常枚举
 *
 * @author zgd
 */

public enum ProductErrorCodeEnum implements BaseErrorCodeEnum {
    /**************************************************************************
     *  前三位是业务分类，后三位是编号
     *************************************************************************/
    DEVICE_GET_TOKEN_ERROR("000001", "获取设备token异常");

    private String errorCode;
    private String errorMsg;

    ProductErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }
}
