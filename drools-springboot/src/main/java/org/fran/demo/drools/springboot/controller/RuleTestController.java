package org.fran.demo.drools.springboot.controller;

import org.fran.demo.drools.springboot.service.RuleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qiushi
 * @date 2023/3/16
 */
@RestController
@RequestMapping("/test/rule")
public class RuleTestController {
    @Resource
    RuleService ruleService;

    @GetMapping(value = "/run", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public String run(){
        ruleService.ruleRun();
        return "success";
    }
}
