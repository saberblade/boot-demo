package com.example.boot_demo;

public class Response <T> {
    private T data;
    private boolean success;
    private String errorMsg;


    public static <K> Response newSuccess(K data) {
        Response response = new Response();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <Void> Response<Void> newFail(String errorMsg) {
        Response<Void> response = new Response<>();
        response.setSuccess(false);
        response.setErrorMsg(errorMsg);
        return response;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

