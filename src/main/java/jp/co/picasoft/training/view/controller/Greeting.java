package jp.co.picasoft.training.view.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/greeting")
public class Greeting {

    @GetMapping("/hello")
    public String greeting(Model model) {
        model.addAttribute("name", "田中陽子");
        return "hello";
    }

    @GetMapping(value = "/some")
    public @ResponseBody Map<String, String> retrieveUserInfo() {
        Map<String, String> m = new HashMap<>();
        m.put("id", "1");
        m.put("name", "田中雄一");
        return m;
    }

    @GetMapping("/vueinthymeleaf")
    public String getHtml() {
        return "vueinthymeleaf";
    }
}
