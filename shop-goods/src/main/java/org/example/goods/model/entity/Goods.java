package org.example.goods.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_goods")
public class Goods {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private Boolean deleted;

    private Long createAt;

    private Long updateAt;

}
