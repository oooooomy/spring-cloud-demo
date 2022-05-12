package org.example.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.goods.model.entity.Goods;

/**
 * @author Gao Yuan Ming
 */
public interface GoodsService {

    /**
     * 根据id查找商品
     *
     * @param id 商品id
     * @return 商品
     */
    Goods findById(Integer id);

    /**
     * 添加商品
     *
     * @param goods 商品信息
     */
    void save(Goods goods);

    /**
     * 删除商品 逻辑删除
     *
     * @param id 商品id
     * @throws Exception 异常
     */
    void remove(Integer id) throws Exception;

    /**
     * 更新商品
     *
     * @param goods 商品
     */
    void update(Goods goods);

    /**
     * 查找所有未删除的商品
     *
     * @param current .
     * @param size    .
     * @return .
     */
    Page<Goods> listNotDeleted(long current, long size);

    /**
     * 查找所有商品 管理员
     *
     * @param current .
     * @param size    .
     * @return .
     */
    Page<Goods> listDeleted(long current, long size);

}
