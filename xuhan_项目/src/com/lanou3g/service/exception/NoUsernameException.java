package com.lanou3g.service.exception;

public class NoUsernameException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在！！！！";
    }
}
