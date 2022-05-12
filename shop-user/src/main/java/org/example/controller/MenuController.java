package org.example.controller;

import org.example.common.api.Result;
import org.example.model.entity.Menu;
import org.example.service.MenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_MENU)")
    public Result<List<Menu>> list() {
        return Result.ok(menuService.list());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_MENU)")
    public Result<Object> remove(@PathVariable Integer id) {
        menuService.remove(id);
        return Result.ok();
    }

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_MENU)")
    public Result<Object> save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok();
    }

    @PutMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_MENU)")
    public Result<Object> update(@RequestBody Menu menu) {
        menuService.update(menu);
        return Result.ok();
    }

}
