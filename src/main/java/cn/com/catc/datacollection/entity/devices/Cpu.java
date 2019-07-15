package cn.com.catc.datacollection.entity.devices;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_DEV_CPU
 * @author 
 */
@Data
public class Cpu implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 对应实体索引
     */
    private Integer cpuindex;

    /**
     * CPU 利用率百分比数据
     */
    private Double value;


}