package cn.com.lyh.project.fund.service.impl;

import cn.com.lyh.project.fund.config.MapConfig;
import cn.com.lyh.project.fund.dto.FundInfo;
import cn.com.lyh.project.fund.service.FundService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * FundServiceImpl
 *
 * @author liuyuhua
 * @date 2021-05-27 16:24
 */
@Service
public class FundServiceImpl implements FundService {
    Logger log = LoggerFactory.getLogger(FundServiceImpl.class);

    @Autowired
    private MapConfig    mapConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${fund.query.url}")
    private String       fund_query_url;

    @Override
    public List<FundInfo> getFunds() {

        return fundQuery().stream().sorted(Comparator.comparing(FundInfo::getV).reversed()).collect(Collectors.toList());
    }

    public List<FundInfo> fundQuery() {

        // 基金配置信息
        Map<String, String> fundMap = mapConfig.getMap();
        final Double[] count = {0d};
        log.info("查询时间：" + LocalDateTime.now());
        List<FundInfo> funds = new ArrayList<>();
        fundMap.forEach((fundCode, fundPart) -> {
            ResponseEntity<String> entity = restTemplate.getForEntity(fund_query_url, String.class, fundCode);
            if (entity.getStatusCode() == HttpStatus.OK) {
                String body = entity.getBody();
                String fundInfo = body.replace("jsonpgz(", "").replace(");", "");
                FundInfo info = JSONObject.parseObject(fundInfo, FundInfo.class);
                info.setCyfe(Double.parseDouble(fundPart));
                double v = info.getCyfe() * info.getGszzl() / 100;
                info.setV(Double.valueOf(String.format("%.2f", v)));
                funds.add(info);
                count[0] += v;
            } else {
                log.error("基金查询失败：{}", entity.getBody());
            }
        });
        log.info("预计总收入：" + count[0]);
        return funds;
    }
}
