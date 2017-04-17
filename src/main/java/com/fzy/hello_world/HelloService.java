package com.fzy.hello_world;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Service("helloService")
//设置非单例模式
//@Scope("prototype")
public class HelloService {

    private String finStr="helloStr";

    public void service(){
        System.out.println("com.fzy.hello_world.HelloService");
    }

    public void changStr(String str){
        finStr=str;
    }

    public String getStr(){
        return finStr;
    }
}
