package cn.com.catc.datacollection.entity.system;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SYS_AREAS
 * @author 
 */
@Data
public class Areas extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 父索引
     */
    private Long pindex;

    /**
     * 组织机构名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 描述
     */
    private String describe;

}