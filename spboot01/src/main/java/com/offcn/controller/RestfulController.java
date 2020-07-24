package com.offcn.controller;

import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restUser")
public class RestfulController {

    private List<User> list=new ArrayList<>();

    //post 新增
    @PostMapping("/")
    @ApiOperation(value="新增用户", notes="这是一个非常厉害的新增用户")
    @ApiImplicitParam(name = "user", value = "使用JSON传递用户的信息", required = true)

    public List<User> add(@RequestBody User user){
        list.add(user);
        return list;
    }


    //get 查询
    @GetMapping("/")
    public List<User> get(){

        return list;
    }

    //get 查询
    @GetMapping("/{id}/{age}")
    public User get(@PathVariable("id") Integer id,@PathVariable("age") int age){

        System.out.println("age="+age);
        for (User user : list) {
            if (user.getId().intValue()==id.intValue()){
                return user;
            }
        }

        return null;
    }

    //put 修改
    @PutMapping("/")
    public List<User> update(@RequestBody User user){
        for (User u : list) {
            if (u.getId().intValue()==user.getId().intValue()){
                u.setUserName(user.getUserName());
                u.setAge(user.getAge());
                u.setGender(user.getGender());
            }
        }

        return list;
    }

    //delete 删除
    @DeleteMapping("/{id}")
    public List<User> delete(@PathVariable("id") Integer id){

        for (int i =0;i<list.size();i++){
            if (list.get(i).getId().intValue()==id.intValue()){
                list.remove(i);
            }
        }

        return list;
    }

}