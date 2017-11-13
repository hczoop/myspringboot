package com.example.demo.controller;

import com.example.demo.bean.Loan;
import com.example.demo.bean.User;
import com.example.demo.exception.MyException;
import com.example.demo.service.LoanService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.*;

/**
 * Created by xing on 2017/6/19.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LoanService loanService;

    @Value(value = "${roncoo.secret}")
    private String secret;

    @Value(value = "${roncoo.number}")
    private int id;

    @Value(value = "${roncoo.desc}")
    private String desc;

    @RequestMapping
    String index() throws Exception {
        logger.debug("this is a log test, debug");
        logger.info("this is a log test, info ==");
        System.out.println("888888");
        return "Hello11 World! spring 4444";
        //throw new Exception("发生错误");
    }

    @RequestMapping(value="/get",method = RequestMethod.GET)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "第三方房贷");
        map.put("name", name);
        map.put("secret", secret);
        map.put("id", id);
        map.put("desc", desc);
        return map;
    }

    @RequestMapping("/get/{id}/{name}")
    public User getUser(@PathVariable Long id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(18);
        return user;
    }

    @PostMapping("/getUser/{id}/{userName}")
    public User updateUserById(@PathVariable Long id,@PathVariable String userName){
        if(StringUtils.isEmpty(userName)){
            throw new MyException("用户名参数为空");
        }
        int i = userService.updateUser(userName, id);
        if(i>0){
            return userService.findOne(id);
        }else{
            throw new MyException("无数据,参数不正确");
        }
    }


    @RequestMapping("/getLoan/{id}")
    public Loan getLoan(@PathVariable String id) {
        Loan loan = loanService.findLoanById(id);
        logger.info("获取的loan： {}",loan);
        return loan;
    }

}

