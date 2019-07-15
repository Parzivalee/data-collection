package cn.com.catc.datacollection.entity.servers;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SER_INTERFACE
 * @author 
 */
@Data
public class Interface extends BaseEntity {

    /**
     * 索引
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
     * UTC 时间
     */
    private Date time;

    /**
     * 接口物理索引
     */
    private Long phyindex;

    /**
     * 网络设备实体信息索引
     */
    private Long entityindex;

    /**
     * 端口类型
     */
    private Integer porttype;

    /**
     * 接口索引
     */
    private Integer ifindex;

    /**
     * 接口名称
     */
    private String ifname;

    /**
     * 接口别名
     */
    private String ifalias;

    /**
     * 接口描述
     */
    private String ifdesc;

    /**
     * 接口管理状态
     */
    private Integer adminstatus;

    /**
     * 接口操作状态
     */
    private Integer operstatus;

    /**
     * 接口带宽
     */
    private Integer speed;

    /**
     * 接口类型
     */
    private Integer iftype;

    /**
     * 接口最大传输单元
     */
    private Integer ifmtu;

    /**
     * 接口MAC 地址
     */
    private String ifphysaddress;

    /**
     * 接口IP 地址
     */
    private String ip;


}