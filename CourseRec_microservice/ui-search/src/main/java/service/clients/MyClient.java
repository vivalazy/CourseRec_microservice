package service.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.models.Product;

/**
 * Created by wangkeqiang on 17-6-21.
 */
@FeignClient("rating")
public interface MyClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products/search/findProductsByUser?id={id}")
    PagedResources<Product> findProductsByUser(@PathVariable("id") String id);
}
