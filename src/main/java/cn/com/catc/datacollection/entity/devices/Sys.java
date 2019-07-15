package cn.com.catc.datacollection.entity.devices;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_DEV_SYS
 * @author 
 */
@Data
public class Sys extends BaseEntity {

    /**
     * 索引(json中无此字段)
     */
    private Long id;

    /**
     * 所属组织机构(根据json文件路径获得,json中无此字段)
     */
    private Long areaid;

    /**
     * IP 地址(根据json文件路径获得,json中无此字段)
     */
    private String ipadress;

    /**
     * 入库时间
     */
    private Date recordtime;

    /**
     * 设备属性字段索引
     */
    private Integer sysindex;

    /**
     * 属性值
     */
    private String value;


}