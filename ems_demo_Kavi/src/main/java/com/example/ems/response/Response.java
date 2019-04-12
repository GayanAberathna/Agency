package com.example.ems.response;

public class Response {
    private boolean success;
    private String message;
    private String tag;

    public Response() {
    }

    public Response(boolean success, String tag, String message) {
        this.success = success;
        this.tag = tag;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
