package com.zhuguang.jack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "密码不正确")
public class PasswordCheckException extends RuntimeException {

}
