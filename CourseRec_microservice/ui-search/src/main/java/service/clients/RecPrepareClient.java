package service.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.models.Recommendation_prepare;

import java.util.List;

/**
 * Created by jinyuanyuan on 2017/6/27.
 */
@FeignClient("recommendation-service")
public interface RecPrepareClient {

    @RequestMapping(method = RequestMethod.GET, value = "/findAllPrepare")
    Iterable<Recommendation_prepare> findAllPrepare();

    @RequestMapping(method = RequestMethod.GET, value = "/savePrepare")
    void save();

    @RequestMapping(method = RequestMethod.GET, value = "/findRecPrepare")
    List<Recommendation_prepare> findRecPrepare(@RequestParam("userid") String userid);

    //    @RequestMapping("/delete")
//    public void delete(@RequestParam(value = "id")Long id){
//        recoService.delete(id);
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/deletePrepare")
    void deletePrepare(@RequestParam("id") Long id);

}
