package cn.com.catc.datacollection.entity.system;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SYS_GROUPS
 * @author 
 */
@Data
public class Groups extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 管理员组名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 描述
     */
    private String describe;


}