package cn.com.catc.datacollection.entity.system;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SYS_MANAGERS
 * @author 
 */
@Data
public class Managers extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 所属组织机构【对应组织机构的index】
     */
    private Long areaid;

    /**
     * 管理员名称
     */
    private String name;

    /**
     * 登录名
     */
    private String login;

    /**
     * 最近登录时间
     */
    private Date lasttime;

    /**
     * 总计登录次数
     */
    private Integer loginnum;

    /**
     * 管理员手机
     */
    private String phone;

    /**
     * 所属管理员组【对应管理员组的index】
     */
    private Long groupid;

    /**
     * 对应工单角色【对应工单角色的index】
     */
    private String role;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 描述
     */
    private String describe;


}