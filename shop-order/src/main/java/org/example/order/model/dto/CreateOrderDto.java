package org.example.order.model.dto;

import lombok.Data;

/**
 * @author Gao Yuan Ming
 * 后端拼装Order数据 防止传来错误的金额、数量
 */
@Data
public class CreateOrderDto {

    private Integer goodsId;

    private Integer userId;

    private Integer goodsCount;

}
