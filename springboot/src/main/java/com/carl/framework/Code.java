package com.carl.framework;

/**
 * 错误信息枚举类型
 * @ClassName: Error
 * @Description: TODO
 *
 */
public enum Code {
	/**
     * 成功
     */
    OK(0, "成功"),
    /**
     * 失败
     */
    ERROR(9999, "处理失败"),
    
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(9999, "未知错误"),

    /*10段，用于定义入参错误*/
    /**
     * 参数为空
     */
    EMPTY_PARAMETER_ERROR(1001, "参数为空"),
    
    /**
     * 该账户未登录
     */
     NOT_LOGGED(1004,"该账户未登录"),

    ;
    /**
     * 错误代码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String msg;

    private Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
