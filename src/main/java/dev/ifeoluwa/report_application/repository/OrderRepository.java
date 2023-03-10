package dev.ifeoluwa.report_application.repository;

import dev.ifeoluwa.report_application.dto.OrderReport;
import dev.ifeoluwa.report_application.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author on 09/03/2023
 * @project
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

//    @Query(
//            name = "OrderReportMapping",
//            nativeQuery = true,
//            value = "SELECT DATE(created_at) AS date, COUNT(*) AS total_order, SUM(total_price) AS total_order_amount " +
//            "FROM orders " +
//            "WHERE created_at >= :startDate AND created_at <= :endDate " +
//            "GROUP BY DATE(created_at)")
//    List<OrderReport> findOrdersByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT NEW dev.ifeoluwa.report_application.dto.OrderReport(o.createdAt, COUNT(o), SUM(o.totalPrice)) " +
            "FROM Orders o " +
            "WHERE o.createdAt >= :startDate AND o.createdAt <= :endDate " +
            "GROUP BY o.createdAt")
    List<OrderReport> findOrdersByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
