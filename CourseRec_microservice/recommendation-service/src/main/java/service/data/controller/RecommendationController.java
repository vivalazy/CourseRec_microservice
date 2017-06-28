package service.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.data.domain.entity.Recommendation;
import service.data.domain.entity.Recommendation_prepare;
import service.data.service.RecPrepareService;
import service.data.service.RecommendationService;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService recoService;

    @Autowired
    private RecPrepareService recoPrepareService;



    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam(value = "userInfo")Recommendation userInfo){
        // 内存数据库操作
        recoService.save(userInfo);
        return "save ok";
    }


    /**
     * 根据userid查找用户
     * @param userid
     * @return
     */
    @RequestMapping("/findRecommendation")
    public List<Recommendation> findRecommendation(@RequestParam(value = "userid")String userid){
        System.out.println("input" + recoService.findRecommendation(userid).iterator().next().getCourseName() + " "+recoService.findRecommendation(userid).iterator().next().getCourseName()
        +" "+recoService.findRecommendation(userid).iterator().next().getCourse_url() +" "+recoService.findRecommendation(userid).iterator().next().getReco_score());
        return recoService.findRecommendation(userid);
    }


    @RequestMapping("/save")
    public String save(){
        // 内存数据库操作
//        private String userId;
//        private String courseId;
//        private String courseName;
//        private String course_url;
//        private double reco_score;
//        recoService.save(new Recommendation("4","1234","化学1", "http://",0.8));
        recoService.save(new Recommendation("1","a","化学：常见物质", "http://11",0.8));
        recoService.save(new Recommendation("1","b","化学：空气与水", "http://22",0.5));
        recoService.save(new Recommendation("2","c","语文", "http://33",0.8));
        recoService.save(new Recommendation("2","d","物理", "http://44",0.8));
        recoService.save(new Recommendation("3","e","生物", "http://55",0.8));
        recoService.save(new Recommendation("3","f","英语", "http://66",0.8));
        recoService.save(new Recommendation("4","g","地理", "http://77",0.8));
        recoService.save(new Recommendation("4","h","历史", "http://88",0.8));
        recoService.save(new Recommendation("4","i","政治", "http://99",0.8));

        System.out.println("save ok");
//        recoService.save(new Recommendation("1002","1234","1234", "content1"));
//        recoService.save(new Recommendation("1003","1234","1234", "content1"));
//        recoService.save(new Recommendation("1004","1234","1234", "content1"));
//        recoService.save(new Recommendation("1005","1234","1234", "content1"));
        return "save ok";
    }

    /**
     * 获取所有用户数据.
     * @return
     */
    @RequestMapping("/findAll")
    public Iterable<Recommendation> findAll(){
        // 内存数据库操作
        System.out.println("into findAll");
        return recoService.findAll();
    }

    /**
     * 根据用户id删除用户
     * @param id
     */
    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "id")Long id){
        recoService.delete(id);
    }


    @RequestMapping("/deleteAll")
    public void deleteAll( ){
        recoService.deleteAll();
    }

//    /**
//     * 修改用户密码
//     * @param userid
//     * @param password
//     */
//    @RequestMapping("/updatePassword")
//    public void updatePassword(@RequestParam(value = "userid")String userid,@RequestParam(value = "password")String password){
//        recoService.updatePassword(userid,password);
//    }
    /**
     * 根据userid查找用户
     * @param userid
     * @return
     */
    @RequestMapping("/findRecPrepare")
    public List<Recommendation_prepare> findRecPrepare(@RequestParam(value = "userid")String userid){
//        System.out.println("input" + recoPrepareService.findRecommendation(userid).iterator().next().getCourseName() + " "+recoPrepareService.findRecommendation(userid).iterator().next().getCourseName()
//                +" "+recoPrepareService.findRecommendation(userid).iterator().next().getCourse_url() +" "+recoPrepareService.findRecommendation(userid).iterator().next().getReco_score());
        return recoPrepareService.findRecommendation(userid);
    }


    @RequestMapping("/savePrepare")
    public String savePrepare(){
        // 内存数据库操作
//        private String userId;
//        private String courseId;
//        private String courseName;
//        private String course_url;
//        private double reco_score;
//        recoService.save(new Recommendation("4","1234","化学1", "http://",0.8));
        recoPrepareService.save(new Recommendation_prepare("1","a","化学：碳", "http://11",1.0));
        recoPrepareService.save(new Recommendation_prepare("1","b","化学：一氧化碳", "http://22",0.5));
        recoPrepareService.save(new Recommendation_prepare("2","c","语文", "http://33",0.8));
        recoPrepareService.save(new Recommendation_prepare("2","d","物理", "http://44",0.8));
        recoPrepareService.save(new Recommendation_prepare("3","e","生物", "http://55",0.8));
        recoPrepareService.save(new Recommendation_prepare("3","f","英语", "http://66",0.8));
        recoPrepareService.save(new Recommendation_prepare("4","g","地理", "http://77",0.8));
        recoPrepareService.save(new Recommendation_prepare("4","h","历史", "http://88",0.8));
        recoPrepareService.save(new Recommendation_prepare("4","i","政治", "http://99",0.8));

        System.out.println("save ok");
//        recoService.save(new Recommendation("1002","1234","1234", "content1"));
//        recoService.save(new Recommendation("1003","1234","1234", "content1"));
//        recoService.save(new Recommendation("1004","1234","1234", "content1"));
//        recoService.save(new Recommendation("1005","1234","1234", "content1"));
        return "save ok";
    }

    /**
     * 获取所有用户数据.
     * @return
     */
    @RequestMapping("/findAllPrepare")
    public Iterable<Recommendation_prepare> findAllPrepare(){
        // 内存数据库操作
        System.out.println("into findAll");
        return recoPrepareService.findAll();
    }

    /**
     * 根据用户id删除用户
     * @param id
     */
    @RequestMapping("/deletePrepare")
    public void deletePrepare(@RequestParam(value = "id")Long id){
        recoPrepareService.delete(id);
    }


    @RequestMapping("/deleteAllPrepare")
    public void deleteAllPrepare( ){
        recoPrepareService.deleteAll();
    }
}
