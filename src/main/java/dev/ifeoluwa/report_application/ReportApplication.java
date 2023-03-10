package dev.ifeoluwa.report_application;

import dev.ifeoluwa.report_application.service.ConsumerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ReportApplication {

//    @Autowired
//    private ConsumerService consumerService;

    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class, args);
    }

//    @PostConstruct
//    public void init() {
//        consumerService.receive();
//    }

}
