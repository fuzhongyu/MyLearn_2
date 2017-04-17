package com.fzy.hello_world;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Created by fuzhongyu on 2017/4/11.
 */
//排序，对list有效map无效
//@Order(2)
@Service("worldServiceImp1")
public class WorldServiceImp1 implements WorldService{

    public void service() {
        ser("com.fzy.hello_world.WorldServiceImp1");
    }


}
