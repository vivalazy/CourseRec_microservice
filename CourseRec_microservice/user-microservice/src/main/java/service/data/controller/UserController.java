package service.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.data.domain.entity.User;
import service.data.service.UserService;

/**
 * Created by wuton on 2017/6/22.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam(value = "userInfo")User userInfo){
        // 内存数据库操作
        userService.save(userInfo);
        return "save ok";
    }


    /**
     * 根据userid查找用户
     * @param userid
     * @return
     */
    @RequestMapping("/findUser")
    public User findUser(@RequestParam(value = "userid")String userid){
        System.out.println("input");
        return userService.findUser(userid);
    }


    @RequestMapping("/save")
    public String save(){
        // 内存数据库操作
        userService.save(new User("4","1234","1234", "haha"));
        System.out.println("save ok");
//        userService.save(new User("1002","1234","1234", "content1"));
//        userService.save(new User("1003","1234","1234", "content1"));
//        userService.save(new User("1004","1234","1234", "content1"));
//        userService.save(new User("1005","1234","1234", "content1"));
        return "save ok";
    }

    /**
     * 获取所有用户数据.
     * @return
     */
    @RequestMapping("/findAll")
    public Iterable<User> findAll(){
        // 内存数据库操作
        System.out.println("into findAll");
        return userService.findAll();
    }

    /**
     * 根据用户id删除用户
     * @param id
     */
    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "id")Long id){
        userService.delete(id);
    }

    /**
     * 修改用户密码
     * @param userid
     * @param password
     */
    @RequestMapping("/updatePassword")
    public void updatePassword(@RequestParam(value = "userid")String userid,@RequestParam(value = "password")String password){
        userService.updatePassword(userid,password);
    }
}
