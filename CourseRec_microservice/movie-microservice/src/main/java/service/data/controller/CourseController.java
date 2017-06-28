package service.data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.data.domain.Course;
import service.data.service.CourseService;

import java.util.List;

/**
 * Created by hasee on 2017/6/27.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String register(@RequestParam(value = "courseInfo")Course courseInfo){
        // 内存数据库操作
        courseService.save(courseInfo);
        return "save ok";
    }


    /**
     * 根据userid查找用户
     * @param userid
     * @return
     */
    @RequestMapping("/findCourse")
    public List<Course> findCourse(@RequestParam(value = "userid")String userid){
        System.out.println("input");
        return courseService.findCourse(userid);
    }


    @RequestMapping("/save")
    public String save(){
        // 内存数据库操作
        courseService.save(new Course("1","1","化学：空气", "95","2014/9/28 21:48:57"));
        courseService.save(new Course("1","1","化学：氧气", "80","2014/9/29 18:48:56"));
        courseService.save(new Course("1","1","化学：水", "75","2014/9/30 17:44:55"));
        courseService.save(new Course("4","1","化学：水", "75","2014/9/30 17:44:55"));
        courseService.save(new Course("4","1","化学：空气", "95","2014/9/28 21:48:57"));
        courseService.save(new Course("4","1","化学：氧气", "80","2014/9/29 18:48:56"));
        courseService.save(new Course("3","1","化学：水", "75","2014/9/30 17:44:55"));
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
    public Iterable<Course> findAll(){
        // 内存数据库操作
        System.out.println("into findAll");
        return courseService.findAll();
    }

    /**
     * 根据用户id删除用户
     * @param id
     */
    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "id")Long id){
        courseService.delete(id);
    }

    @RequestMapping("/deleteAll")
    public void deleteAll(){
        courseService.deleteAll();
    }

    /**
     * 修改用户密码
     * @param userid
     * @param password
     */

}
