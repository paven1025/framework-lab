package com.paven.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cpw
 * @date 2021/9/7 6:03 下午
 */
@ControllerAdvice
public class LabControllerAdvice {

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class})
    @ResponseBody
    public String arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        return "ArrayIndexOutOfBoundsException";
    }

    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public String arithmeticException(ArithmeticException e) {
        e.printStackTrace();
        return "ArithmeticException";
    }
}
