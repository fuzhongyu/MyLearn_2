package com.fzy.hello_world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private HelloService helloService2;

    /**
     * 注：一个接口有两个实现类的时候需要指定实例化的类
     *
     * 抛出的异常：NoUniqueBeanDefinitionException	表示有多个候选类可用	注入时显式指定用哪一个 如 @Autowired @Qualifier("fooBarServiceImpl2")
     */
    @Autowired
    @Qualifier("worldServiceImp1")
    private WorldService worldService;


    /**
     * list autowired
     */
    @Autowired
    private List<WorldService> worldServiceList;

    /**
     * map autowired
     */
    @Autowired
    private Map<String,WorldService> worldServiceMap;


    @RequestMapping(value = "")
    public String helloWorld(){
        helloService.service();
        helloService1.service();
        worldService.service();
        for (WorldService worldService:worldServiceList){
            System.out.println("-->list:"+worldService.getClass().getName());
        }

        for(Map.Entry entry:worldServiceMap.entrySet()){
            System.out.println("==>map:"+entry.getKey()+"    "+entry.getValue().getClass().getName());
        }
        return "/hello_world/helloWorld";
    }

    @RequestMapping("uploadPage")
    public String uploadPage(){
        return "/hello_world/fileUpload";
    }


    /**
     * 文件上传测试
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("uploadFile")
    public String uploadFile(MultipartFile file, HttpServletRequest request){

        if(!file.isEmpty()){
            String url="/Users/fuzhongyu//IdeaProjects/MyLearn/MyLearn_2/"+file.getOriginalFilename();
            System.out.println(url);
            try {
               File fi=new File(url);
               file.transferTo(fi);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/helloWorld/";

    }

    @RequestMapping(value = "checkPic")
    public void checkPic(HelloEntity helloEntity,HttpServletResponse response){

        String pic=helloEntity.getTitle();
       StringBuilder returnMessage=new StringBuilder("{");
        if(pic!=null){
            String[] strings=pic.split("\\.");
            String suffix=strings[strings.length-1];
            if("jpg".equals(suffix)||"jpeg".equals(suffix)||"png".equals(suffix)){
                returnMessage.append("\"msg\":\"success\"}");
            }else {
                returnMessage.append("\"msg\":\"fail\"}");
            }
        }

        try {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(returnMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * responseBody将对象转成json格式
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkPic_2",produces = "application/json;charset=utf-8")
    public List<HelloEntity> checkPic_2(@CookieValue(value = "t",required = false) String t){
        List<HelloEntity> list=new ArrayList<HelloEntity>();
        HelloEntity helloEntity=new HelloEntity();
        helloEntity.setTitle("hello fzy");
        HelloEntity helloEntity1=new HelloEntity();
        helloEntity1.setTitle("hello mr fu");
        list.add(helloEntity);
        list.add(helloEntity1);
        return list;
    }

    /**
     * 设置请求格式和cookie事例
     * @param t
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkPic_2_1",produces = "application/json;charset=utf-8")
    public List<HelloEntity> checkPic_2_1(@CookieValue(value = "t",required = false) String t){
        List<HelloEntity> list=new ArrayList<HelloEntity>();
        return list;
    }

    /**
     * spring内置对象转json格式
     * @return
     */
    @RequestMapping(value = "checkPic_3",method = RequestMethod.GET)
    public ResponseEntity<List<HelloEntity>> checkPic_3(){
        List<HelloEntity> list=new ArrayList<HelloEntity>();
        HelloEntity helloEntity=new HelloEntity();
        helloEntity.setTitle("hello fzy");
        HelloEntity helloEntity1=new HelloEntity();
        helloEntity1.setTitle("hello mr fu");
        list.add(helloEntity);
        list.add(helloEntity1);
        return new ResponseEntity<List<HelloEntity>>(list, HttpStatus.OK);
    }


    /**
     * spring 默认创建的是一个单例，helloService2_hashcode和 helloService_hashcode的值会一样
     * 配置非单例模式可设置service类中的scope
     * @return
     */
    @RequestMapping(value = "testSingle")
    public  String testSpringSingleton(){
        helloService.changStr("fzy");
        System.out.println(helloService2.getStr());
        System.out.println("helloService2_hashcode:"+helloService2.hashCode()+"  helloService_hashcode: "+helloService.hashCode());
        return "redirect:/helloWorld/testSingle2";
    }

    @RequestMapping(value = "testSingle2")
    public  String testSpringSingleton2(){
        System.out.println(helloService2.getStr());
        System.out.println("helloService2_hashcode:"+helloService2.hashCode()+"  helloService_hashcode: "+helloService.hashCode());
        return "redirect:/helloWorld/";
    }

    @RequestMapping(value = "form")
    public String form(HelloEntity helloEntity){
        System.out.println(helloEntity.hashCode());
        return "/hello_world/helloWorldForm";
    }



}
