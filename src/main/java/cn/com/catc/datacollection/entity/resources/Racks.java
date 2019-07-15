package cn.com.catc.datacollection.entity.resources;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_RACKS
 * @author 
 */
@Data
public class Racks extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 所属组织机构
     */
    private Long areaid;

    /**
     * 所属机房
     */
    private Long roomid;

    /**
     * 机架编码
     */
    private String no;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 机架容量
     */
    private Integer capacity;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;


}