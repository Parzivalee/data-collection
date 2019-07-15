package cn.com.catc.datacollection.entity.resources;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_RES_ROOM
 * @author 
 */
@Data
public class Room extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 所属组织机构
     */
    private Long areaid;

    /**
     * 机房名称
     */
    private String roomname;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 机房地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 备注
     */
    private String memo;



}