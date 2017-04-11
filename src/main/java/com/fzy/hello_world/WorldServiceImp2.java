package com.fzy.hello_world;

import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/11.
 */
@Service("worldServiceImp2")
public class WorldServiceImp2 implements WorldService{

    public void service() {
        System.out.println("com.fzy.hello_world.WorldServiceImp2");
    }
}
