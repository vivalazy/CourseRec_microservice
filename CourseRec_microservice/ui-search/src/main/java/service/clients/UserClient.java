package service.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.models.Recommendation;
import service.models.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user-microservice")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    Iterable<User> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    void save();

    @RequestMapping(method = RequestMethod.GET, value = "/findByUserid")
    List<User> findByUserid(@RequestParam("userid") String userid);

   // @RequestMapping(method = RequestMethod.GET, value = "/updatePassword")
    //void findRecommendation(@RequestParam("userid") String userid,@RequestParam("userid") String userid);
   /* @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    List<User> findById(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    List<User> findMe(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.POST, value = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    void createUser(@RequestBody User user);*/
}
