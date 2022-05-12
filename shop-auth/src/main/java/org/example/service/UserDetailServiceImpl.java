package org.example.service;

import org.example.clients.UserClient;
import org.example.common.api.Result;
import org.example.common.auth.HeaderToken;
import org.example.model.entity.Menu;
import org.example.model.vo.UserDetailsVo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<UserDetailsVo> result = userClient.login(username, HeaderToken.SERVICE_TOKEN);
        if (result.getCode() != HttpServletResponse.SC_OK) {
            throw new UsernameNotFoundException(result.getMsg());
        }

        UserDetailsVo userDetailsVo = result.getData();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Menu menu : userDetailsVo.getMenus()) {
            authorities.add(new SimpleGrantedAuthority(menu.getAuthority()));
        }
        return new User(username,
                userDetailsVo.getUser().getPassword(),
                true,
                true,
                true,
                !userDetailsVo.getRole().isLocked(),
                authorities);
    }

}
