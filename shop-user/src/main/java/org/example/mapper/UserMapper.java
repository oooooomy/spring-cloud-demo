package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.entity.User;

/**
 * @author Gao Yuan Ming
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
