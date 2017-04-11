package com.fzy.hello_world.test;

import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Service("test_helloService")
public class HelloService {

    public void service(){
        System.out.println("com.fzy.hello_world.test.HelloService");
    }
}
