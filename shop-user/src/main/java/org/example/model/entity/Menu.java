package org.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_menu")
public class Menu {

    private Integer id;

    private String name;

    private String url;

    /**
     * 放入SpringSecurity Context
     */
    private String authority;

}
