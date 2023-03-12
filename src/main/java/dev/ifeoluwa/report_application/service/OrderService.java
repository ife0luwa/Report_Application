package dev.ifeoluwa.report_application.service;

import dev.ifeoluwa.report_application.dto.OrderReport;
import dev.ifeoluwa.report_application.repository.OrderReportInterface;
import dev.ifeoluwa.report_application.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author on 10/03/2023
 * @project
 */
@Service
@Slf4j
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<?> getOrderReport(LocalDate startDate, LocalDate endDate) {
        List<OrderReport> orderReports = orderRepository.findOrdersByDate(startDate, endDate);
        return orderReports;
    }
}
