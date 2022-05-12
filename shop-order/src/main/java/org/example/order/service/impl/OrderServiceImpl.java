package org.example.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.api.Result;
import org.example.order.feign.GoodsFeign;
import org.example.order.feign.StorageFeign;
import org.example.order.mapper.OrderMapper;
import org.example.order.model.dto.CreateOrderDto;
import org.example.order.model.dto.GoodsDto;
import org.example.order.model.entity.Order;
import org.example.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Gao Yuan Ming
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private GoodsFeign goodsFeign;

    @Resource
    private StorageFeign storageFeign;

    @Override
    public Order create(CreateOrderDto dto) throws Exception {

        //更新库存
        Result<?> deductResult = storageFeign.deduct(dto.getGoodsId(), dto.getGoodsCount());

        //返回状态判断
        if (deductResult.getCode() != HttpServletResponse.SC_OK) {
            throw new Exception(deductResult.getMsg());
        }

        //库存减少完毕 拼装订单信息
        Result<GoodsDto> goodsResult = goodsFeign.findById(dto.getGoodsId());
        //返回状态判断
        if (goodsResult.getCode() != HttpServletResponse.SC_OK) {
            throw new Exception(deductResult.getMsg());
        }

        GoodsDto goodsDto = goodsResult.getData();

        //计算订单金额
        BigDecimal amount = BigDecimal.ZERO
                .add(goodsDto.getPrice().multiply(new BigDecimal(String.valueOf(dto.getGoodsCount()))));

        Order order = new Order(UUID.randomUUID().toString(),
                dto.getUserId(),
                goodsDto.getId(),
                0,
                dto.getGoodsCount(),
                amount,
                System.currentTimeMillis(),
                System.currentTimeMillis(),
                false
        );
        //设置订单id
        order.setId(UUID.randomUUID().toString());
        //保存订单到数据库
        orderMapper.insert(order);
        return order;
    }

    @Override
    public void update(Order order) {
        orderMapper.updateById(order);
    }

    @Override
    public void remove(String orderId) throws Exception {
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            throw new Exception("订单ID错误");
        }
        order.setDeleted(true);
        orderMapper.updateById(order);
    }

    @Override
    public Page<Order> findNotDeleted(Long current, Long size) {
        Page<Order> page = new Page<>(current, size);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.in("deleted", false);
        return orderMapper.selectPage(page, wrapper);
    }

    @Override
    public Page<Order> findDeleted(Long current, Long size) {
        Page<Order> page = new Page<>(current, size);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.in("deleted", true);
        return orderMapper.selectPage(page, wrapper);
    }

}
