package sample.configs

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

/**
 * @author tolkv
 * @version 16/11/14
 */

@EnableAutoConfiguration
class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class)
    }
}
