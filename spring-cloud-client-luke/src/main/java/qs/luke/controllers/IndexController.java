package qs.luke.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class IndexController {

    @Value("${luke.word}")
    private String word;

    @Value("${luke.msg}")
    private String msg;

    @RequestMapping({"/",""})
    public String indexPage( Model model){
        model.addAttribute("word",word);
        model.addAttribute("msg",msg );
        return "index";
    }
}
