package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@ComponentScan(basePackages = { "service.config", "service.data" })
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   // @Autowired
   // private RepositoryRestMvcConfiguration repositoryRestConfiguration;

    //@PostConstruct
    //public void postConstructConfiguration() {
      //  repositoryRestConfiguration.config().exposeIdsFor(Movie.class);
   // }
}
