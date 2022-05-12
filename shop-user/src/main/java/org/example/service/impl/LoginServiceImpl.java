package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.MenuMapper;
import org.example.mapper.RoleMapper;
import org.example.mapper.UserMapper;
import org.example.model.entity.Menu;
import org.example.model.entity.Role;
import org.example.model.entity.User;
import org.example.model.enums.UserType;
import org.example.model.vo.UserDetailsVo;
import org.example.service.LoginService;
import org.example.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuService menuService;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetailsVo loginByUsername(String username) throws Exception {
        User loginUser = userMapper.selectOne(
                new QueryWrapper<User>().in("username", username));

        if (loginUser == null) {
            throw new Exception("不存在的用户名");
        }

        List<Menu> hasMenus;

        Role hasRole = roleMapper.selectById(loginUser.getId());

        if (UserType.SUPER_ADMIN.getValue().equals(loginUser.getType())) {
            hasMenus = menuMapper.selectList(null);
        } else {
            hasMenus = menuService.listMenusByRole(hasRole);
        }

        return new UserDetailsVo(loginUser, hasRole, hasMenus);
    }

}
