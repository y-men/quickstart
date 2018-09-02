package qs.cloud.restclient.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController

public class LuckyWordController{

    @Value("${lucky.word}")
    private String luckyword;

    @GetMapping("/")
    public String getLuckyWorkd() {
        return " >>>>>>> " + luckyword;
    }
}
