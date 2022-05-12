package org.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_user_role")
public class UserRole {

    /**
     * user_id做主键 只能有一个角色
     */
    private Integer userId;

    private Integer roleId;

}
