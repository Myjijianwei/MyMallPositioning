package com.MyMallPositioning.exceptionhandler;


import com.MyMallPositioning.common_utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 实现了全局异常处理，能够捕获并处理控制器中抛出的异常。
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public R handleMyException(MyException e){
        return handleError(e, e.getMsg()).code(e.getCode());
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public R handleArithmeticException(ArithmeticException e){
        return handleError(e, "执行了ArithmeticException异常处理");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R handleException(Exception e){
        return handleError(e, "执行了全局异常处理");
    }

    private R handleError(Exception e, String message) {
        log.error(message + ": ", e);
        return R.error().message(message).details(e.getMessage());
    }
}