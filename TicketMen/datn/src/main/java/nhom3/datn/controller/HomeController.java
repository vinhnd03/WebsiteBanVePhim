package nhom3.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
        @ResponseBody
        @RequestMapping({"/home/index"})
    public String home(){
        return "index.html";
    }
}
