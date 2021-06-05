package cn.com.lyh.project.fund.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

/**
 * BeanConfig
 *
 * @author liuyuhua
 * @date 2021-05-27 16:28
 */
@Component
public class BeanConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> httpMessageConverters = restTemplate.getMessageConverters();
        // 处理返回结果中文乱码问题
        httpMessageConverters.forEach(httpMessageConverter -> {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                StringHttpMessageConverter messageConverter = (StringHttpMessageConverter) httpMessageConverter;
                messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
            }
        });
        return restTemplate;
    }
}
