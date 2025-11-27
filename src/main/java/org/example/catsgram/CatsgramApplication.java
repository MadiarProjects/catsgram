package org.example.catsgram;

import org.example.catsgram.model.MyCar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CatsgramApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CatsgramApplication.class, args);
//        MyCar myCar=context.getBean(MyCar.class);
//        myCar.start();

    }
}
