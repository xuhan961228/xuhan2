package com.lanou3g.service.exception;

public class LoginException extends Exception {
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
