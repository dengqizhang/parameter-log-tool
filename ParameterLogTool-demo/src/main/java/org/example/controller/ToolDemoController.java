package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.annotation.LogTool;
import org.example.config.ThreadLocalConfig;
import org.example.service.ToolDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe:
 * @Author Cary
 * @Date 2024/3/18
 **/

@RestController
public class ToolDemoController {
    @Autowired
    private ToolDemoService toolDemoService;

    @Autowired
    ThreadLocalConfig threadLocalConfig;

    @GetMapping("/test")
    @LogTool
    public String test(@RequestParam("ss") String ss){
        threadLocalConfig.set(ss);
        toolDemoService.processMethodParameters(getClass(),"test",ss);
        String ssPlus = "output parameter";
        return ssPlus;
    }
}
