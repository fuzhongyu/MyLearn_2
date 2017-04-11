package com.fzy.hello_world;

import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Service("helloService")
public class HelloService {

    public void service(){
        System.out.println("com.fzy.hello_world.HelloService");
    }
}
