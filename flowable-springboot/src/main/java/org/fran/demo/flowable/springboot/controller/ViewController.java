package org.fran.demo.flowable.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fran
 * @Description
 * @Date 2020/10/20 15:08
 */
@ApiIgnore
@Controller
@RequestMapping("/page")
public class ViewController {

    @RequestMapping("/home")
    public ModelAndView selectTest(
            HttpServletRequest request,
            HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        return new ModelAndView("/home", map);
    }
}
