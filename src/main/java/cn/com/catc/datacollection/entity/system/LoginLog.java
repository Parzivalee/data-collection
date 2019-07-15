package cn.com.catc.datacollection.entity.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TB_BD_CIVIL_SYS_LOGINLOG
 * @author 
 */
@Data
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 索引
     */
    private Long id;

    /**
     * 登录时间
     */
    private Date time;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 客户端IP 地址
     */
    private String ip;


}