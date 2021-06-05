package cn.com.lyh.project.fund.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 * 从配置文件中读取数据映射到map
 * 注意：必须实现set方法
 * @author liuyuhua
 * @since 2020-08-01 15:23
 */
@Configuration
@ConfigurationProperties(prefix = "fund")
@PropertySource("classpath:fund.properties")
public class MapConfig {

    /**
     * 从配置文件中读取的map开头的数据
     * 注意：名称必须与配置文件中保持一致
     */
    private Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

