package org.example.controller;

import org.example.common.api.Result;
import org.example.model.entity.Role;
import org.example.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_ROLE)")
    public Result<List<Role>> list() {
        return Result.ok(roleService.list());
    }

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_ROLE)")
    public Result<?> save(@RequestBody Role role) {
        roleService.save(role);
        return Result.ok();
    }

    @PutMapping("")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_ROLE)")
    public Result<?> update(@RequestBody Role role) {
        roleService.update(role);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(T(org.example.constant.UserRoles).ROLE_SUPER_ADMIN, " +
            "T(org.example.constant.UserRoles).ROLE_ROLE)")
    public Result<?> remove(@PathVariable Integer id) throws Exception {
        roleService.remove(id);
        return Result.ok();
    }

}
