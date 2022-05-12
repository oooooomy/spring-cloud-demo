package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.model.entity.User;
import org.example.model.enums.UserType;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectList(null);
    }

    @Override
    public void save(User user) throws Exception {
        checkSuperAdmin(user.getId());
        userMapper.insert(user);
    }

    @Override
    public void update(User user) throws Exception {
        checkSuperAdmin(user.getId());
        userMapper.updateById(user);
    }

    @Override
    public void remove(Integer userId) throws Exception {
        checkSuperAdmin(userId);
        userMapper.deleteById(userId);
    }

    private void checkSuperAdmin(Integer userId) throws Exception {
        if (userMapper.selectById(userId).getType().equals(UserType.SIMPLE_ADMIN.getValue())) {
            throw new Exception("超级管理员无法操作");
        }
    }

}
