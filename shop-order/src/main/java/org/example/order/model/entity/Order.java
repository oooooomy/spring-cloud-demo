package org.example.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_order")
@AllArgsConstructor
public class Order {

    private String id;

    private Integer userId;

    private Integer goodsId;

    private Integer status;

    private Integer goodsCount;

    private BigDecimal amount;

    private Long createAt;

    private Long updateAt;

    private Boolean deleted;

}
