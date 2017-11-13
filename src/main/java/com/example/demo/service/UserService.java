package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xing on 2017/6/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(){
        User user = null;
        for (int i=0;i<100;i++){
            user = new User("test"+i,100-i);
            userRepository.save(user);
        }
    }

    public User findByName(String name){
         return userRepository.findByName(name);
    }

    public User findByNameAndAge(String name, Integer age){
        return  userRepository.findByNameAndAge(name,age);
    }

    public User findUser(String name){
        return  userRepository.findUser(name);
    }

    public User findOne(Long id){
        return  userRepository.findOne(id);
    }

    @Transactional
    public int updateUser(String name, Long id){
        return  userRepository.updateUser(name,id);
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Page<User> queryAllUser(int pageNumber,int pageSize){
        PageRequest pageRequest = this.buildPageRequest(pageNumber,pageSize);
        return  userRepository.findAll(pageRequest);
    }

    /**
     * 构建PageRequest
     * pageNumber:表示第几页 , 是从0开始的，0是第一页
     * pagzSize：每页显示多少条数据
     * sort:对那个字段进行排序
     * @param pageNumber
     * @param pageSize
     * @return
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize) {
        return new PageRequest(pageNumber-1, pageSize, new Sort(new Sort.Order(Sort.Direction. DESC,"id")));
    }


    /**
     * 通过原生sql查询
     * @param age
     * @return
     */
    public List<User> findUserByAge(Integer age){
        return  userRepository.findUserByAge(age);
    }

    /**
     * 通过原生sql分页查询
     * @param age
     * @return
     */
    public Page<User> findUserPage(Integer age,int pageNumber, int pageSize){
        PageRequest pageRequest = this.buildPageRequest(pageNumber,pageSize);
        return  userRepository.findUserPage(age,pageRequest);
    }

}
