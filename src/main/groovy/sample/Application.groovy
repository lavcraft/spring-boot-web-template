package sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

/**
 * @author tolkv
 * @version 16/11/14
 */

@Configuration
@Import(value = [
        MongoConfig.class,
        RepositoryRestMvcConfiguration.class,
        WebSocketConfig.class
])
@EnableAutoConfiguration
@ComponentScan(basePackages = [
        'sample.repositories'
        , 'sample.domain'
        , 'sample.controllers'
])
class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class)
    }


}
