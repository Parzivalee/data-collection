package cn.com.catc.datacollection.entity.servers;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SER_DISK
 * @author 
 */
public class Disk implements Serializable {

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
     * 磁盘序号
     */
    private Integer diskindex;

    /**
     * 磁盘使用率百分比数据
     */
    private Double value;


}