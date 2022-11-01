package org.hqu.elevatorManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ElevatorManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElevatorManageApplication.class, args);
    }

}
