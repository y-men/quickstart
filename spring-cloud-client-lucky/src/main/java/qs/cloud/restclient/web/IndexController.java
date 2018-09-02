package qs.cloud.restclient.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {

    @Value("${lucky.word}")
    private String luckyword;



    @RequestMapping( {"", "/","/index"})
    public String  getIndexPage (Model model) {
        model.addAttribute("word",luckyword);
        log.debug(">>>>>>>>>>" + model);
        return "index";
    }

}
