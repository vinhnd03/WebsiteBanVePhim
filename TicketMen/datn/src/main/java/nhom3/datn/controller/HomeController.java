package nhom3.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
        @RequestMapping({"/home/index","/"})
    public String home(){
        return "layout/home";
    }

        @RequestMapping({"/admin", "/admin/home/index"})
    public String admin(){
        return "redirect:/admin/index2.html";
    }

    @RequestMapping("/qna")
    public String qna(){
        return "other/qna";
    }

    @RequestMapping("/discount")
    public String discount(){
        return "other/discount";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "other/contact";
    }

    @RequestMapping("/service")
    public String service(){
        return "other/service";
    }
}

