package org.example.service;

import org.example.model.entity.User;

import java.util.List;

/**
 * @author Gao Yuan Ming
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<User> list();

    /**
     * 添加用户
     *
     * @param user 用户信息
     */
    void save(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param user 用户信息
     */
    void update(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param userId 用户id
     */
    void remove(Integer userId) throws Exception;

}
