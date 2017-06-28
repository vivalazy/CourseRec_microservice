package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@EnableNeo4jRepositories
@EnableZuulProxy
@EnableHystrix
public class Application {

    // Used to bootstrap the Neo4j database with demo data
//    @Value("${aws.s3.url}")
//    String datasetUrl;
//
//    public Application() {
//        setBasePackage("service");
//    }
//
//    @Bean(destroyMethod = "shutdown")
//    public GraphDatabaseService graphDatabaseService() {
//        return new GraphDatabaseFactory().newEmbeddedDatabase("user.db");
//    }


    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
//        RepositoryRestConfiguration restConfiguration = ctx.getBean("config", RepositoryRestConfiguration.class);
//        restConfiguration.exposeIdsFor(User2.class);
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> {
            // Import graph data for users
            String userImport = String.format("LOAD CSV WITH HEADERS FROM \"%s/users2.csv\" AS csvLine\n" +
                    "MERGE (user:User2:_User { id: csvLine.id, password:csvLine.password, age: toInt(csvLine.age), gender: csvLine.gender, occupation: csvLine.occupation, zipcode: csvLine.zipcode })", datasetUrl);

            neo4jTemplate().query(userImport, null).finish();
        };
    }


    @Bean
    public ResourceProcessor<Resource<User2>> movieProcessor() {
        return new ResourceProcessor<Resource<User2>>() {
            @Override
            public Resource<User2> process(Resource<User2> resource) {

                resource.add(new Link("/movie/movies", "movies"));
                return resource;
            }
        };
    }*/
}
