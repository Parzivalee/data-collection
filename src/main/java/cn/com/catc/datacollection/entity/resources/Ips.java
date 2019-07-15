package cn.com.catc.datacollection.entity.resources;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_IPS
 * @author 
 */
@Data
public class Ips extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 所属组织机构
     */
    private Long areaid;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 所属IP 段
     */
    private Long ipsegid;

    /**
     * IP 地址
     */
    private String ip;

    /**
     * 使用用户
     */
    private Long usrerid;

    /**
     * 安装的服务器编码
     */
    private Integer cusDev;

    /**
     * 安装的网络设备编码
     */
    private Integer netDev;

    /**
     * 录入时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;

}