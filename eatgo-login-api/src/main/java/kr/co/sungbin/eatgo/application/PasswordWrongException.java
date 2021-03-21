package kr.co.sungbin.eatgo.application;

public class PasswordWrongException extends RuntimeException {

    PasswordWrongException() {
        super("Password is wrong");
    }
}
