package cn.com.catc.datacollection.entity.resources;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_USER
 * @author 
 */
@Data
public class User implements Serializable {

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
     * 用户名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系电子邮箱
     */
    private String email;

    /**
     * 录入时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;


}