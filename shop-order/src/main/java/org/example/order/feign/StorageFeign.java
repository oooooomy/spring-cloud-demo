package org.example.order.feign;

import org.example.common.api.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gao Yuan Ming
 */
@Component
@FeignClient("shop-storage")
public interface StorageFeign {

    /**
     * 库存服务 减少库存
     *
     * @param goodId 商品id
     * @param count  数量
     * @return 结果
     */
    @GetMapping("/deduct")
    Result<?> deduct(@RequestParam Integer goodId, @RequestParam Integer count);

}
