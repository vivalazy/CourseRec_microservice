package service.clients;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.models.Recommendation;

import java.util.List;

@FeignClient("recommendation-service")
public  interface  RecommendationClient {
    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    Iterable<Recommendation> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    void save();

    @RequestMapping(method = RequestMethod.GET, value = "/findRecommendation")
    List<Recommendation> findRecommendation(@RequestParam("userid") String userid);

//    @RequestMapping("/delete")
//    public void delete(@RequestParam(value = "id")Long id){
//        recoService.delete(id);
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    void delete(@RequestParam("id") Long id);

//    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
//    List<Recommendation> findMe(@PathVariable("id") String id);

//    @RequestMapping(method = RequestMethod.POST, value = "/users",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    void createRecommendation(@RequestBody Recommendation recommendation);

}
