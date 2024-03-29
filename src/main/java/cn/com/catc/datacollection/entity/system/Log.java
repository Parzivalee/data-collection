package cn.com.catc.datacollection.entity.system;

import cn.com.catc.datacollection.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SYS_LOG
 * @author 
 */
@Data
public class Log extends BaseEntity {

    /**
     * 索引
     */
    private Long id;

    /**
     * 日志级别
     */
    private Integer leveled;

    /**
     * 客户端IP 地址
     */
    private String ip;

    /**
     * 日志时间
     */
    private Date time;

    /**
     * 日志内容
     */
    private String describe;


}