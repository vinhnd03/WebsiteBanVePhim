package nhom3.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
        @RequestMapping({"/home/index","/"})
    public String home(){
        return "movie/list";
    }

        @RequestMapping({"/admin", "/admin/home/index"})
    public String admin(){
        return "redirect:/admin/index.html";
    }

    @RequestMapping("/qna")
    public String qna(){
        return "other/qna";
    }

    @RequestMapping("/discount")
    public String discount(){
        return "other/discount";
    }
}
