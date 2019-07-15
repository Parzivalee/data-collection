package cn.com.catc.datacollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * @Author lwj
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DataCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectionApplication.class, args);
    }

}
