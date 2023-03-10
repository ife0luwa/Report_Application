package dev.ifeoluwa.report_application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.ifeoluwa.report_application.entity.Orders;
import dev.ifeoluwa.report_application.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author on 09/03/2023
 * @project
 */
@Service
@Slf4j
public class ConsumerService {

    private OrderRepository orderRepository;

    @Autowired
    public ConsumerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "create-Order")
    public void receive(String orderPayload) {
        try{
            ObjectMapper mapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule());
            Orders order = mapper.readValue(orderPayload, Orders.class);
            log.info("Received order: {}", order);
            orderRepository.save(order);
            log.info("Saved order to database");
        } catch (Exception e) {
            log.error("Failed to parse order payload: {}", orderPayload, e);
        }
    }
}
