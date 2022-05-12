package org.example.storage.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Gao Yuan Ming
 */
@Data
@TableName("t_storage")
public class Storage {

    private Integer goodsId;

    private Integer count;

    private Long createAt;

    private Long updateAt;

}
