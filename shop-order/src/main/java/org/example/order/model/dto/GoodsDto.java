package org.example.order.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Gao Yuan Ming
 */

@Data
public class GoodsDto {

    private Integer id;

    private String name;

    private BigDecimal price;

}
