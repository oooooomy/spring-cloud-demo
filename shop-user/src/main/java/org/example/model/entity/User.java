package org.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_user")
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer type;

}
