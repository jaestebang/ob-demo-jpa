package com.nttdata.obdemojpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ObDemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObDemoJpaApplication.class, args);
        log.info("Demo - init mockup");
    }

}
