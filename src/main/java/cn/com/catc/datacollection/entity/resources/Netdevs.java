package cn.com.catc.datacollection.entity.resources;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_NETDEVS
 * @author 
 */
@Data
public class Netdevs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 索引
     */
    private Long id;

    /**
     * 所属组织机构
     */
    private Long areaid;

    /**
     * 所属地市机构
     */
    private String areaname;

    /**
     * 网络设备名称
     */
    private String name;

    /**
     * 网络设备类型
     */
    private String type;

    /**
     * 网络设备型号
     */
    private String catalog;

    /**
     * 使用用户
     */
    private Long usrerid;

    /**
     * 机架编码
     */
    private String rackno;

    /**
     * 所占U位数
     */
    private Integer ucount;

    /**
     * 设备IP地址
     */
    private String ip;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 录入时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;



}