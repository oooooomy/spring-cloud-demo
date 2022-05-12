package org.example.controller;

import org.example.common.api.Result;
import org.example.common.auth.HeaderToken;
import org.example.model.vo.UserDetailsVo;
import org.example.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Result<UserDetailsVo> loginByUsername(@RequestParam String username,
                                                 HttpServletRequest request) throws Exception {
        if (!HeaderToken.SERVICE_TOKEN.equals(request.getHeader(HeaderToken.SERVICE_TOKEN_HEADER))) {
            throw new Exception("Service token error");
        }
        return Result.ok(loginService.loginByUsername(username));
    }

}
