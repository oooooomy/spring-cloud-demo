package org.example.clients;

import org.example.common.api.Result;
import org.example.common.auth.HeaderToken;
import org.example.model.vo.UserDetailsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gao Yuan Ming
 */
@Component
@FeignClient("shop-user")
public interface UserClient {

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @param token    请求头
     * @return 用户详细信息
     */
    @PostMapping("/user/login")
    Result<UserDetailsVo> login(@RequestParam String username,
                                @RequestHeader(HeaderToken.SERVICE_TOKEN_HEADER) String token);

}
