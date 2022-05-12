package org.example.storage.service.impl;

import org.example.storage.mapper.StorageMapper;
import org.example.storage.model.entity.Storage;
import org.example.storage.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Gao Yuan Ming
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void insert(Storage storage) {
        storage.setCreateAt(System.currentTimeMillis());
        storageMapper.insert(storage);
    }

    @Override
    public void deduct(Integer goodsId, Integer count) throws Exception {
        Storage storage = storageMapper.selectById(goodsId);
        if (storage == null) {
            throw new Exception("商品ID错误");
        }
        if (storage.getCount() < count) {
            throw new Exception("库存不足");
        }

        storage.setCount(storage.getCount() - count);
        storage.setUpdateAt(System.currentTimeMillis());
        storageMapper.updateById(storage);
    }

    @Override
    public void add(Integer goodsId, Integer count) throws Exception {
        Storage storage = storageMapper.selectById(goodsId);
        if (storage == null) {
            throw new Exception("商品ID错误");
        }
        storage.setCount(storage.getCount() + count);
        storage.setUpdateAt(System.currentTimeMillis());
        storageMapper.updateById(storage);
    }

}
