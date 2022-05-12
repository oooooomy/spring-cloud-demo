package org.example.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.order.model.dto.CreateOrderDto;
import org.example.order.model.entity.Order;

/**
 * @author Gao Yuan Ming
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param dto 创建订单数据
     */
    Order create(CreateOrderDto dto) throws Exception;

    /**
     * 更新订单
     *
     * @param order 订单数据
     */
    void update(Order order);

    /**
     * 删除订单
     *
     * @param orderId 订单id
     * @throws Exception 订单id不存在
     */
    void remove(String orderId) throws Exception;

    /**
     * 查找所有未删除订单
     *
     * @param current .
     * @param size    .
     * @return .
     */
    Page<Order> findNotDeleted(Long current, Long size);

    /**
     * 查找所未删除订单
     *
     * @param current .
     * @param size    .
     * @return .
     */
    Page<Order> findDeleted(Long current, Long size);

}
