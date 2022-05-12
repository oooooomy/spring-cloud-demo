package org.example.common.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gao Yuan Ming
 */
public class ResponseUtil {

    public static void writeJson(HttpServletResponse response, Object data) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSON.toJSONString(data));
    }

}
