package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.clients.MovieClient;
import service.clients.RecPrepareClient;
import service.clients.RecommendationClient;
import service.models.*;
import service.clients.UserClient;
import java.util.List;
import service.clients.RecPrepareClient;
import service.models.Recommendation_prepare;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangying on 2017/6/24.
 */
@Controller
public class HelloController {
    @Autowired
    private RecommendationClient RecoClient;
    @Autowired
    private RecPrepareClient RecPrepareClient;
    @Autowired
    private MovieClient movieclient;
    @Autowired
    private UserClient userclient;
    UserInfo userInfo = new UserInfo();
    Userchange userchange=new Userchange();


    @RequestMapping(value = "/login")
    public String index(ModelMap map) {
        if(movieclient.findAll().iterator().next().getCourseid().isEmpty()) {
            movieclient.save();
            userclient.save();
            RecoClient.save();
            RecPrepareClient.save();
        }
        map.addAttribute("userInfo", userInfo);
        return "index";
    } //
    /*@RequestMapping(value = "/reset")
    public String index1(ModelMap map) {
        map.addAttribute("userchange", userchange);
        return "index1";
    }
    @RequestMapping(value = "/study",method=RequestMethod.POST)
    public String features1( Userchange userchange ,ModelMap map) {
        //  movieclient.save();
        // userclient.save();
        // RecoClient.save();
        // RecPrepareClient.save();
        //map.addAttribute("userInfo", userInfo);
        System.out.println(userchange.getUserid());
        String userid = userchange.getUserid();
        List<User> userlist=userclient.findByUserid(userid);
        if(userlist.get(0).getPassword().equals(userchange.getOldpassword())) {
            // String userid = userInfo.getUserid(); //本来应该是index页面传过来的用户名
            userclient.updatePassword(userchange.getUserid(),userchange.getNewpassword());
            List<Course> resultList = movieclient.findCourse(userid);
            System.out.println(resultList.get(0).getCoursename());
            map.addAttribute("userInfo", userInfo);
            map.addAttribute("course", resultList);
            map.addAttribute("id", userchange.getUserid());
            map.addAttribute("pass", userchange.getNewpassword());/// /变量名是reco
            // System.out.println(resultList.get(0).getCoursename());
            //map.addAttribute("userInfo", userInfo);
            // return "tour";
            return "features";
        }
        else
        {
            return "index";
        }
    }*/
    @RequestMapping(value = "/studyRecord",method=RequestMethod.POST)
    public String features( UserInfo userInfo ,ModelMap map) {
      //  movieclient.save();
       // userclient.save();
       // RecoClient.save();
       // RecPrepareClient.save();
        //map.addAttribute("userInfo", userInfo);
        System.out.println(userInfo.getUserid());
        String userid = userInfo.getUserid();
        List<User> userlist=userclient.findByUserid(userid);
        if(userlist.get(0).getPassword().equals(userInfo.getPassword())) {
           // String userid = userInfo.getUserid(); //本来应该是index页面传过来的用户名
            List<Course> resultList = movieclient.findCourse(userid);
            System.out.println(resultList.get(0).getCoursename());
            map.addAttribute("userInfo", userInfo);
            map.addAttribute("course", resultList);
            map.addAttribute("id", userInfo.getUserid());
            map.addAttribute("pass", userInfo.getPassword());/// /变量名是reco
           // System.out.println(resultList.get(0).getCoursename());
            //map.addAttribute("userInfo", userInfo);
            // return "tour";
            return "features";
        }
        else
        {
            return "index";
        }
    }
    @RequestMapping(value = "/review",method=RequestMethod.POST)
    public String tour(UserInfo userInfo,ModelMap map) {
        //String userid = "1"; //本来应该是index页面传过来的用户名
        String userid = userInfo.getUserid();
        System.out.println(userInfo.getUserid());
        //String userid = userInfo.getUserid();
        List<Recommendation> resultList = RecoClient.findRecommendation(userid);
        map.addAttribute("reco", resultList); //变量名是reco
        System.out.println(resultList.get(0).getCourseName());
        map.addAttribute("userInfo", userInfo);
        map.addAttribute("id", userInfo.getUserid());
        map.addAttribute("pass", userInfo.getPassword());
        return "tour";
    } //复习

//    @RequestMapping(value = "/login", params = {"valid"}, method = RequestMethod.POST)
//    public String login(ModelMap map, UserInfo userInfo, BindingResult result) {
////        @RequestMapping("/tour")
////        public String tour( ModelMap map) {
//        String userid = "1"; //本来应该是index页面传过来的用户名
////        String userid = user.getUserid();
//        System.out.println("login:"+userid);
//        List<Recommendation> resultList = RecoClient.findRecommendation(userid);
//        map.addAttribute("reco", resultList); //变量名是reco
//        System.out.println(resultList.get(0).getCourseName());
//        return "tour";
//    } //复习


    //预习页面
    @RequestMapping(value="/prepare",method=RequestMethod.POST)
    public String pricing(UserInfo userInfo,ModelMap map) {
        String userid = userInfo.getUserid();
        //String userid = "1"; //本来应该是index页面传过来的用户名
        List<Recommendation_prepare> resultList = RecPrepareClient.findRecPrepare(userid);
        map.addAttribute("reco", resultList); //变量名是reco
        System.out.println(resultList.get(0).getCourseName());
        map.addAttribute("userInfo", userInfo);
        map.addAttribute("id", userInfo.getUserid());
        map.addAttribute("pass", userInfo.getPassword());
        return "pricing";
    }
}
