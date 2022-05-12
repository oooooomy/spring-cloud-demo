package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.MenuMapper;
import org.example.mapper.RoleMenuMapper;
import org.example.model.entity.Menu;
import org.example.model.entity.Role;
import org.example.model.entity.RoleMenu;
import org.example.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> list() {
        return menuMapper.selectList(null);
    }

    @Override
    public List<Menu> listMenusByRole(Role role) {

        QueryWrapper<RoleMenu> roleMenuQueryWrapper = new QueryWrapper<>();
        roleMenuQueryWrapper.in("role_id", role.getId());
        List<RoleMenu> roleMenus = roleMenuMapper.selectList(roleMenuQueryWrapper);

        List<Menu> menus = new ArrayList<>();

        for (RoleMenu roleMenu : roleMenus) {
            menus.add(menuMapper.selectById(roleMenu.getMenuId()));
        }

        return menus;
    }

    @Override
    public void remove(Integer menuId) {
        menuMapper.deleteById(menuId);
    }

    @Override
    public void save(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.updateById(menu);
    }

}
