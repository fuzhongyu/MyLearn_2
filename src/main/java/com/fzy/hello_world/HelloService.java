package com.fzy.hello_world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Service
public class HelloService {

    public void service(){
        System.out.println("this is helloService");
    }
}
