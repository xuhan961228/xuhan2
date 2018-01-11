package com.lanou3g.service.exception;

public class RegisterExcuption extends LoginException {
    @Override
    public String getMessage() {
        return "账号已存在！！！！";
    }
}
