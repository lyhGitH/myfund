package cn.com.lyh.project.fund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author liuyuhua
 * @date 2020/8/1
 */
@SpringBootApplication
// @EnableScheduling
public class FundApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FundApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FundApplication.class);
    }
}
