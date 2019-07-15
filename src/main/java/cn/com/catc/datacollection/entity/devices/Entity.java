package cn.com.catc.datacollection.entity.devices;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_DEV_ENTITY
 * @author 
 */
@Data
public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 所属组织机构(根据json文件路径获得,json中无此字段)
     */
    private Long areaid;

    /**
     * 入库时间
     */
    private Date recordtime;

    /**
     * IP 地址(根据json文件路径获得,json中无此字段)
     */
    private String ipadress;

    /**
     * 父索引
     */
    private Long pindex;

    /**
     * 索引
     */
    private Long entityindex;

    /**
     * 硬件类型(json中为class)
     */
    private Integer classtype;

    /**
     * 硬件名称
     */
    private String name;

    /**
     * 硬件描述
     */
    private String descr;

    /**
     * 硬件别名
     */
    private String alias;

    /**
     * 硬件供应商类型
     */
    private String vtype;

    /**
     * CIN(目前不知道含义)
     */
    private String cin;

    /**
     * RELPOS(目前不知道含义)
     */
    private String relpos;

    /**
     * 硬件版本
     */
    private String hwr;

    /**
     * 固件版本
     */
    private String fwr;

    /**
     * 软件版本
     */
    private String swr;

    /**
     * 硬件序列号
     */
    private String snum;

    /**
     * MFG(目前不知道含义)
     */
    private String mfg;

    /**
     * ASSET(目前不知道含义)
     */
    private String asset;

    /**
     * 是否可更换单元
     */
    private Integer fru;

    /**
     * 模块名称
     */
    private String model;

}