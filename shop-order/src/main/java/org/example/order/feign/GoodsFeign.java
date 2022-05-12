package org.example.order.feign;

import org.example.common.api.Result;
import org.example.order.model.dto.GoodsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gao Yuan Ming
 */
@Component
@FeignClient("shop-goods")
public interface GoodsFeign {

    /**
     * 查询商品详情
     *
     * @param id id
     * @return .
     */
    @GetMapping("/findById")
    Result<GoodsDto> findById(@RequestParam Integer id);

}
