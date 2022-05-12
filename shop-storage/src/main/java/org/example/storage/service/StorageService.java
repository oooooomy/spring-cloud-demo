package org.example.storage.service;

import org.example.storage.model.entity.Storage;

/**
 * @author Gao Yuan Ming
 */
public interface StorageService {

    /**
     * 添加库存信息
     *
     * @param storage 库存信息
     */
    void insert(Storage storage);

    /**
     * 减少库存
     *
     * @param goodsId 商品id
     * @param count   数量
     * @throws Exception 异常
     */
    void deduct(Integer goodsId, Integer count) throws Exception;

    /**
     * 添加库存
     *
     * @param goodsId 商品id
     * @param count   数量
     * @throws Exception 异常
     */
    void add(Integer goodsId, Integer count) throws Exception;

}
