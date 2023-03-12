package dev.ifeoluwa.report_application.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.ifeoluwa.report_application.dto.OrderReport;
import dev.ifeoluwa.report_application.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;


    @Test
    void testGetOrderReport() {
        ArrayList<OrderReport> orderReportList = new ArrayList<>();
        when(orderRepository.findOrdersByDate((LocalDate) any(), (LocalDate) any())).thenReturn(orderReportList);
        List<?> actualOrderReport = orderService.getOrderReport(LocalDate.ofEpochDay(1L), LocalDate.ofEpochDay(1L));
        assertSame(orderReportList, actualOrderReport);
        assertTrue(actualOrderReport.isEmpty());
        verify(orderRepository).findOrdersByDate((LocalDate) any(), (LocalDate) any());
    }
}

