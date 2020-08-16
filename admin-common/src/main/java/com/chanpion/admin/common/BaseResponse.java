package com.chanpion.admin.common;

/**
 * @author April Chen
 * @date 2020/8/4 10:52
 */
public class BaseResponse {
    private int statusCode;
    private String statusMsg;

    public static final BaseResponse SUCCESS = new BaseResponse(0, "success");
    public static final BaseResponse ERROR = new BaseResponse(-1, "error");

    public BaseResponse() {
    }

    public BaseResponse(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public static BaseResponse error(String msg) {
        return new BaseResponse(-1, msg);
    }
}
