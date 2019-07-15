package cn.com.catc.datacollection.entity.resources;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_USEATS
 * @author 
 */
@Data
public class Useats implements Serializable {

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
     * 所属机柜
     */
    private Long rackid;

    /**
     * 在机架上的位置
     */
    private Integer location;

    /**
     * 状态
     */
    private Integer status;

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
     * 创建时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;


}