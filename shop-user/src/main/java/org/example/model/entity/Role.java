package org.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_role")
public class Role {

    private Integer id;

    private String name;

    /**
     * 根据状态限制登陆
     */
    private boolean locked;

}
