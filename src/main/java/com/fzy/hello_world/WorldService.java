package com.fzy.hello_world;

import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Service
public interface WorldService {

    public void service();

    /**
     * 注：java1.8特性，接口也可以有方法体
     */
    default void ser(String str){
        System.out.println(str);
    }
}
