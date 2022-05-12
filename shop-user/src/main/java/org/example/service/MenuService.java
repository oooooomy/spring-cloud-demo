package org.example.service;

import org.example.model.entity.Menu;
import org.example.model.entity.Role;

import java.util.List;

/**
 * @author Gao Yuan Ming
 */
public interface MenuService {

    /**
     * 查询系统所有菜单
     *
     * @return a category tree
     */
    List<Menu> list();

    /**
     * 查询角色下的菜单列表
     *
     * @param role 查询的角色
     * @return 角色下的菜单列表
     */
    List<Menu> listMenusByRole(Role role);

    /**
     * 删除菜单
     *
     * @param menuId 菜单id
     */
    void remove(Integer menuId);

    /**
     * 添加菜单
     *
     * @param menu 菜单数据
     */
    void save(Menu menu);

    /**
     * 更新菜单
     *
     * @param menu 更新数据
     */
    void update(Menu menu);

}
