package jp.co.picasoft.training.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.picasoft.training.common.bean.SystemDate;
import jp.co.picasoft.training.common.service.SystemDateService;

@RestController
@RequestMapping("/systemdate")
public class SystemDateAPIController {
    
    @Autowired
    private SystemDateService systemDateService;
    
    @GetMapping("/getsystemdate")
    public SystemDate getsSystemDate() {
        return systemDateService.getSystemDate();
    }
}
