package org.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_role_menu")
public class RoleMenu {

    private Integer id;

    private Integer roleId;

    private Integer menuId;

}
