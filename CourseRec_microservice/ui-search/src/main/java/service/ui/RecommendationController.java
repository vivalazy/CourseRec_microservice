package service.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.clients.RecommendationClient;
import service.models.Recommendation;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
@Controller
@RequestMapping("/reco")
public class RecommendationController {
        @Autowired
        private RecommendationClient RecoClient;

        @RequestMapping("/findAll")
        public Iterable<Recommendation> findAll(){
            System.out.println("全部用户的推荐课程 "+RecoClient.findAll().toString());
            return RecoClient.findAll();
        }

//    @RequestMapping("/findAll2")
//    public String findAll2(){
//        System.out.println("我的推荐课程 "+RecoClient.findAll());
////        return RecoClient.findAll();
//            return "findALL OK";
//    }

     @RequestMapping("/findRecommendation")
     public List<Recommendation> findRecommendation(@RequestParam(value = "userid") String userid){
//            Iterable<Recommendation>result = RecoClient.findRecommendation(userid);
//            while(result.hasNext()){
//                System.out.println("我的推荐课程 "+result.iterator().next().getCourseName()+" "+result.iterator().next().getCourse_url()
//                +" "+result.iterator().next().getReco_score()+" "+result.iterator().next().getUserId());
//            }
         List<Recommendation>result = RecoClient.findRecommendation(userid);
         for(int i = 0;i<result.size();i++)
             System.out.println("我的推荐课程 "+result.get(i).getCourseName()+" "+result.get(i).getCourse_url()
                +" "+result.get(i).getReco_score()+" "+result.get(i).getUserId() +" "+result.get(i).getCourseId());
            return RecoClient.findRecommendation(userid);
    }

        @RequestMapping("/save")
        public void save(){
            RecoClient.save();
            System.out.println("recommendation save ok");
        }

    @RequestMapping("/delete")
    public void save(Long id){
        RecoClient.delete(id);
        System.out.println("delete ok");
    }

    }

