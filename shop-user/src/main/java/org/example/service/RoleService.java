package org.example.service;

import org.example.model.entity.Role;

import java.util.List;

/**
 * @author Gao Yuan Ming
 */
public interface RoleService {

    /**
     * 查询系统角色
     *
     * @return a category tree
     */
    List<Role> list();

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @throws Exception 角色下还有用户
     */
    void remove(Integer roleId) throws Exception;

    /**
     * 添加角色
     *
     * @param role 角色
     */
    void save(Role role);

    /**
     * 更新角色
     *
     * @param role 角色
     */
    void update(Role role);

}
