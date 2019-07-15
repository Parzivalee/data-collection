package cn.com.catc.datacollection.entity.resources;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_SERVERS
 * @author 
 */
@Data
public class Servers implements Serializable {

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
     * 服务器名称
     */
    private String name;

    /**
     * 服务器类型
     */
    private String type;

    /**
     * 型号
     */
    private String catalog;

    /**
     * 使用用户
     */
    private Long usrerid;

    /**
     * 开始机位编码
     */
    private Long useatno;

    /**
     * 所占U位数
     */
    private Integer ucount;

    /**
     * 服务器IP 地址
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