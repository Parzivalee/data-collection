package cn.com.catc.datacollection.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description Entity基类
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
