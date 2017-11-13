package com.example.demo.controller;

import com.example.demo.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TemplateController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	
	@RequestMapping("writelog")  
    public @ResponseBody Object writeLog()  
    {  
        logger.debug("This is a debug message");  
        logger.info("This is an info message");  
        logger.warn("This is a warn message");  
        logger.error("This is an error message");  
        return "OK";  
    }

    /**
     * 返回html模板
     * @param map
     * @return
     */
    @RequestMapping(value = "/helloHtml",method = RequestMethod.GET)
    public String helloHtml(Map<String,Object> map){
        List<User> list = new ArrayList<User>();
        list.add(new User(11l, "aa",20));
        list.add(new User(22l, "bb",25));
        list.add(new User(33l, "cc", 30));
        map.put("lists", list);
        map.put("hello","显示在模板上的内容");
        map.put("user", new User(22l, "xingixns", 18));
        return "/hello";
    }

    /**
     * 测试vue页面的使用
     * @param map
     * @return
     */
    @RequestMapping(value = "/veHtml",method = RequestMethod.GET)
    public String hellovueHtml(Map<String,Object> map){
        return "/vue/vueInfo";
    }

    @RequestMapping(value = "/vueTest",method = RequestMethod.GET)
    public String vueTest(Map<String,Object> map){
        return "/vue/vueTest";
    }

    @RequestMapping(value = "/vueresource",method = RequestMethod.GET)
    public String vueresource(Map<String,Object> map){
        return "/vue/vue-resource";
    }

    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    public String carttest(Map<String,Object> map){
        return "/vue/cart/cart";
    }

    @RequestMapping(value = "/address",method = RequestMethod.GET)
    public String addresstest(Map<String,Object> map){
        return "/vue/cart/address";
    }
}
