package site.metacoding.dbtest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardTblController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
