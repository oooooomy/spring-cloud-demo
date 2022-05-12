package org.example.controller;

import org.example.common.api.Result;
import org.example.model.entity.User;
import org.example.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public Result<?> test() {
        return Result.ok(SecurityContextHolder.getContext().getAuthentication());
    }

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_USER_CURD)")
    public Result<List<User>> list() {
        return Result.ok(userService.list());
    }

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_USER_CURD)")
    public Result<?> save(@RequestBody User user) throws Exception {
        userService.save(user);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_USER_CURD)")
    public Result<?> remove(@PathVariable Integer id) throws Exception {
        userService.remove(id);
        return Result.ok();
    }

    @PutMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_USER_CURD)")
    public Result<?> update(@RequestBody User user) throws Exception {
        userService.update(user);
        return Result.ok();
    }
}
