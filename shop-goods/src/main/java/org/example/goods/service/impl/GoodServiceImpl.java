package org.example.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.goods.mapper.GoodsMapper;
import org.example.goods.model.entity.Goods;
import org.example.goods.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Gao Yuan Ming
 */
@Service
public class GoodServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Goods findById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public void save(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public void remove(Integer id) throws Exception {
        Goods goods = goodsMapper.selectById(id);
        if (goods == null) {
            throw new Exception("不存在的商品ID");
        }
        goods.setDeleted(true);
        goodsMapper.updateById(goods);
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.updateById(goods);
    }

    @Override
    public Page<Goods> listNotDeleted(long current, long size) {
        Page<Goods> page = new Page<>(current, size);
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.in("deleted", false);
        return goodsMapper.selectPage(page, goodsQueryWrapper);
    }

    @Override
    public Page<Goods> listDeleted(long current, long size) {
        Page<Goods> page = new Page<>(current, size);
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.in("deleted", true);
        return goodsMapper.selectPage(page, goodsQueryWrapper);
    }

}
