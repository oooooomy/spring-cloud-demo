package org.example.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public static <T> Result<T> ok() {
        return new Result<>(200, "success", null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

}
