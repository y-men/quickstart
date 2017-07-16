package qe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*
todo
-	Create my oun banner
-	Add AOP advices
-	Change logging configuration
- 	Metrix

 */

@SpringBootApplication
//@ImportResource("classpath:application-config.xml")
public class SpringbootAopApplication implements CommandLineRunner {

    @Autowired
    HelloMessageService helloMessageService;

    public static void main(String[] args) {

        SpringApplication.run(SpringbootAopApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        String message = helloMessageService.getMessage();
        System.out.println(message);
    }
}
