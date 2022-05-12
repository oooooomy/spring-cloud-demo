package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.RoleMapper;
import org.example.mapper.UserRoleMapper;
import org.example.model.entity.Role;
import org.example.model.entity.UserRole;
import org.example.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> list() {
        return roleMapper.selectList(null);
    }

    @Override
    public void remove(Integer roleId) throws Exception {
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.in("role_id", roleId);
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);
        if (userRoles != null) {
            throw new Exception("角色下存在用户");
        }
        roleMapper.deleteById(roleId);
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateById(role);
    }

}
