package cn.com.catc.datacollection.entity.resources;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_IPSEGS
 * @author 
 */
@Data
public class Ipsegs implements Serializable {

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
     * 状态
     */
    private Integer status;

    /**
     * 起始IP
     */
    private String startip;

    /**
     * 终止IP
     */
    private String endip;

    /**
     * 掩码
     */
    private String netmask;

    /**
     * 网关
     */
    private String gatewayip;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;


}