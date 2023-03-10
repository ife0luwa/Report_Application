package dev.ifeoluwa.report_application.controller;

import dev.ifeoluwa.report_application.dto.OrderReport;
import dev.ifeoluwa.report_application.repository.OrderReportInterface;
import dev.ifeoluwa.report_application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author on 10/03/2023
 * @project
 */
@RestController
@RequestMapping("/api/report")
public class OrderReportController {

    private OrderService orderService;

    @Autowired
    public OrderReportController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<?>> getOrderReport(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        List<?> orderReport = orderService.getOrderReport(startDate, endDate);
        return ResponseEntity.ok(orderReport);
    }
}
