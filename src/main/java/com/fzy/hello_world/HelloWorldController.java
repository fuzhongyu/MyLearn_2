package com.fzy.hello_world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fuzhongyu on 2017/4/10.
 */
@Controller
@RequestMapping(value = "helloWorld")
public class HelloWorldController {


    /**
     * 注：工程中（含依赖jar包） 若有两个同名的类，Spring启动时会报错,这个时候需要在@Service中取别名
     *
     * 抛出的异常：ConflictingBeanDefinitionException	表示类名冲突了	给任一类指定一个别名 如@Service("anotherFooService")
     */
    @Autowired
    private HelloService helloService;

    @Autowired
    private com.fzy.hello_world.test.HelloService helloService1;

    /**
     * 注：一个接口有两个实现类的时候需要指定实例化的类
     *
     * 抛出的异常：NoUniqueBeanDefinitionException	表示有多个候选类可用	注入时显式指定用哪一个 如 @Autowired @Qualifier("fooBarServiceImpl2")
     */
    @Autowired
    @Qualifier("worldServiceImp1")
    private WorldService worldService;


    @RequestMapping(value = "")
    public String helloWorld(){
        helloService.service();
        helloService1.service();
        worldService.service();
        return "/hello_world/helloWorld";
    }
}
