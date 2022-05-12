package org.example.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.api.Result;
import org.example.order.model.dto.CreateOrderDto;
import org.example.order.model.entity.Order;
import org.example.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gao Yuan Ming
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("")
    public Result<Order> create(@RequestBody CreateOrderDto dto) throws Exception {
        return Result.ok(orderService.create(dto));
    }

    @PutMapping("")
    public Result<?> update(@RequestBody Order order) {
        orderService.update(order);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    public Result<?> remove(@PathVariable String id) throws Exception {
        orderService.remove(id);
        return Result.ok();
    }

    @GetMapping("/findNotDeleted")
    public Result<Page<Order>> findNotDeleted(@RequestParam Long current, @RequestParam Long size) {
        return Result.ok(orderService.findNotDeleted(current, size));
    }

    @GetMapping("/findDeleted")
    public Result<Page<Order>> findDeleted(@RequestParam Long current, @RequestParam Long size) {
        return Result.ok(orderService.findNotDeleted(current, size));
    }


}
