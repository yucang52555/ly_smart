package com.smart.mvc.enums;

/**
 * 异常信息
 * @author kangtiancheng
 * @date 2017年8月19日
 */
public enum  ErrorType {

    DEFFAULT,
    UNKNOW_ERROR(-1L, null),
    SIGN_INVALID(72L, "签名无效！"),
    OPERATION_FAILED(73L, "操作失败！"),
    OPERATION_TOO_FAST(74L, "你的操作过快，请稍候..."),
    PARAM_EXCEPTION(100L, "参数错误！"),
    FIND_NULL_EXCEPTION(101L, "未查找到对象！"),
    REQUEST_EXCEPTION(102L, "请求异常！"),
    
    //微信类异常
    WX_APP_AUTH_REQUEST_FAIL(200L, "微信权限请求失败！"),
	WX_APP_OPENID_IS_NULL(201L, "OPENID不能为空！"),
	
	ACCOUNT_USER_NOT_EXIST(300L, "微信用户不存在！");


	/**
     * 错误码
     */
    private Long code;

    /**
     * 描述
     */
    private String message;

    private ErrorType(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    private ErrorType() {
    }

    /**
     * 获取code
     *
     * @return the code
     */
    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}