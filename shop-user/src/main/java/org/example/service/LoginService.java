package org.example.service;

import org.example.model.vo.UserDetailsVo;

/**
 * @author Gao Yuan Ming
 */
public interface LoginService {

    /**
     * 查询用户
     *
     * @param username 用户名
     * @return 用户信息
     * @throws Exception .
     */
    UserDetailsVo loginByUsername(String username) throws Exception;

}
