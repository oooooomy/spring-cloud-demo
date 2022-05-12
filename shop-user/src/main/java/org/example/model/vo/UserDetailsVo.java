package org.example.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.entity.Menu;
import org.example.model.entity.Role;
import org.example.model.entity.User;

import java.util.List;

/**
 * @author Gao Yuan Ming
 */
@Data
@AllArgsConstructor
public class UserDetailsVo {

    private User user;

    private Role role;

    private List<Menu> menus;

}
