package service.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.clients.MovieClient;
import service.models.Course;

import java.util.List;
/**
 * Created by hasee on 2017/6/27.
 */
@Controller
@RequestMapping("/movie")
public class CourseController {
    @Autowired
    private MovieClient movieclient;
    @RequestMapping("/findAll")
    public Iterable<Course> findAll(){
        System.out.println("全部用户的推荐课程 "+movieclient.findAll());
        return movieclient.findAll();
    }
    @RequestMapping("/findCourse")
    public List<Course> findRecommendation(@RequestParam(value = "userid") String userid){
        List<Course> result = movieclient.findCourse(userid);
//            while(result.hasNext()){
//                System.out.println("我的推荐课程 "+result.iterator().next().getCourseName()+" "+result.iterator().next().getCourse_url()
//                +" "+result.iterator().next().getReco_score()+" "+result.iterator().next().getUserId());
//            }

        return movieclient.findCourse(userid);
    }

    @RequestMapping("/save")
    public void save(){
        movieclient.save();
        System.out.println("moviceclient save ok");
    }
}
