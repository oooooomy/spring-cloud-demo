package org.example.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.goods.model.entity.Goods;

/**
 * @author Gao Yuan Ming
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
