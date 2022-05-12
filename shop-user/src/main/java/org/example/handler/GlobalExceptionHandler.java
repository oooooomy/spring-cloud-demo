package org.example.handler;

import org.example.common.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局拦截异常
 *
 * @author Gao Yuan Ming
 */
@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public Object handleException(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        return Result.fail(400, e.getMessage());
    }

}
