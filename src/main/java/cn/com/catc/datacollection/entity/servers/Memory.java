package cn.com.catc.datacollection.entity.servers;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SER_MEMORY
 * @author 
 */
@Data
public class Memory implements Serializable {

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
     * 内存索引(固定-1)
     */
    private Integer memoryindex;

    /**
     * 内存利用率百分比
     */
    private Double value;


}