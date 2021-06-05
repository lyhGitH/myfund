package cn.com.lyh.project.fund.controller;

import cn.com.lyh.project.fund.dto.FundInfo;
import cn.com.lyh.project.fund.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * FundController
 *
 * @author liuyuhua
 * @date 2021-05-27 16:19
 */
@Controller
public class FundController {

    @Autowired
    private FundService fundService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/fund")
    public ModelAndView getFund(ModelAndView model) {
        model.setViewName("fund");

        List<FundInfo> infos = fundService.getFunds();
        // 盈利总和
        double sum = infos.stream().mapToDouble(FundInfo::getV).sum();
        model.addObject("infos", infos);
        model.addObject("sum", sum);
        return model;
    }
}
