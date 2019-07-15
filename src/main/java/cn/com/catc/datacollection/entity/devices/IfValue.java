package cn.com.catc.datacollection.entity.devices;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SER_IFVALUE
 * @author 
 */
@Data
public class IfValue extends BaseEntity {

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
     * 接口流入流量
     */
    private Double fluxin;

    /**
     * 接口流出流量
     */
    private Double fluxout;

    /**
     * 流入单播包率
     */
    private Double ucastin;

    /**
     * 流出单播包率
     */
    private Double ucastout;

    /**
     * 流入多播包率
     */
    private Double mcastin;

    /**
     * 流出多播包率
     */
    private Double mcastout;

    /**
     * 流入广播包率
     */
    private Double bcastin;

    /**
     * 流出广播包率
     */
    private Double bcastout;

    /**
     * 流入丢包率
     */
    private Double discardin;

    /**
     * 流出丢包率
     */
    private Double discardout;

    /**
     * 流入错包率
     */
    private Double errorin;

    /**
     * 流出错包率
     */
    private Double errorout;

    /**
     * UNKNOWNPROTOS（目前不知道含义）
     */
    private Double unknownprotos;

    /**
     * 电压
     */
    private Double opticalvoltage;

    /**
     * 电流
     */
    private Double opticalbiascurrent;

    /**
     * 接收功率
     */
    private Double opticalrxpower;

    /**
     * 发射功率
     */
    private Double opticaltxpower;

    /**
     * IPV6接口流入流量
     */
    private Double ipv6fluxin;

    /**
     * IPV6接口流出流量
     */
    private Double ipv6fluxout;

    /**
     * UTC 时间
     */
    private Date time;

    /**
     * 接口物理索引
     */
    private Long phyindex;

    /**
     * 实体索引
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