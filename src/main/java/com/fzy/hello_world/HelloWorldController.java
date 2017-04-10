package com.fzy.hello_world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Controller
@RequestMapping(value = "helloWorld")
public class HelloWorldController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "")
    public String helloWorld(){
        helloService.service();
        return "/hello_world/helloWorld";
    }
}
