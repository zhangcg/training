package jp.co.picasoft.training.api.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TestRestAPIController {
    
    @GetMapping("/greeting")
    public Map<String, Object> greeting() {
        Map<String, Object>  m = new HashMap<>();
        m.put("code", 0);
        m.put("messages", new String[]{"Good luck!"});
        Map<String, Object>  data = new HashMap<>();
        data.put("id", 1);
        data.put("name", "田中陽子");
        m.put("data", data);
        return m;
    }

    @GetMapping(value="/getSystemDate")
    public String getSystemDate() {
        return "From Restful API: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }
}
