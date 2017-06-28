package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.clients.MovieClient;
import service.clients.RecPrepareClient;
import service.clients.RecommendationClient;
import service.models.Course;
import service.models.Recommendation;
import service.models.Recommendation_prepare;
import service.models.UserInfo;
import service.models.User;
import service.clients.UserClient;
import java.util.List;
import service.clients.RecPrepareClient;
import service.models.Recommendation_prepare;
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
    @RequestMapping(value = "/login")
    public String index(ModelMap map) {
        movieclient.save();
        userclient.save();
        RecoClient.save();
        RecPrepareClient.save();
        //
        map.addAttribute("userInfo", userInfo);
        return "index";
    } //

    @RequestMapping(value = "/studyRecord",method=RequestMethod.POST)
    public String features( UserInfo userInfo ,ModelMap map) {
      //  movieclient.save();
       // userclient.save();
       // RecoClient.save();
       // RecPrepareClient.save();
        System.out.println(userInfo.getUserid());
        String userid = userInfo.getUserid();
        List<User> userlist=userclient.findByUserid(userid);
        if(userlist.get(0).getPassword().equals(userInfo.getPassword())) {
           // String userid = userInfo.getUserid(); //本来应该是index页面传过来的用户名
            List<Course> resultList = movieclient.findCourse(userid);
            System.out.println(resultList.get(0).getCoursename());
            map.addAttribute("course", resultList); //变量名是reco
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
    @RequestMapping("/review")
    public String tour(ModelMap map) {
        String userid = "1"; //本来应该是index页面传过来的用户名
        List<Recommendation> resultList = RecoClient.findRecommendation(userid);
        map.addAttribute("reco", resultList); //变量名是reco
        System.out.println(resultList.get(0).getCourseName());
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
    @RequestMapping("/prepare")
    public String pricing(ModelMap map) {
        String userid = "1"; //本来应该是index页面传过来的用户名
        List<Recommendation_prepare> resultList = RecPrepareClient.findRecPrepare(userid);
        map.addAttribute("reco", resultList); //变量名是reco
        System.out.println(resultList.get(0).getCourseName());
        return "pricing";
    }
}
