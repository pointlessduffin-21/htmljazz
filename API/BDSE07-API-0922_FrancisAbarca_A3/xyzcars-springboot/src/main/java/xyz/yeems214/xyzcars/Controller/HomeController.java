package xyz.yeems214.xyzcars.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String handleRootRequest(Model model) {
        return "index";
    }
}