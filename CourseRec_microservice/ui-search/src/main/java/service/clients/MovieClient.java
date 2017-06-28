package service.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.models.Course;

import java.util.List;

@FeignClient("movie")
public interface MovieClient {
    /*@RequestMapping(
            method = RequestMethod.GET,
            value = "/movies")
    PagedResources<Movie> findAll();

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/movies/search/findByTitleContainingIgnoreCase?title={title}")
    PagedResources<Movie> findByTitleContainingIgnoreCase(@PathVariable("title") String title);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/movies/{id}")
    List<Movie> findById(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET,
            value = "/movies/search/findByIdIn?ids={ids}")
    PagedResources<Movie> findByIds(@PathVariable("ids") String ids);*/
    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    Iterable<Course> findAll();
    @RequestMapping(method = RequestMethod.GET, value = "/save")
    void save();

    @RequestMapping(method = RequestMethod.GET, value = "/findCourse")
    List<Course> findCourse(@RequestParam("userid") String userid);
    /*@RequestMapping(method = RequestMethod.POST, value = "/movies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    void createMovie(@RequestBody Movie movie);*/
}
