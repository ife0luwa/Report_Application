package dev.ifeoluwa.report_application.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author on 10/03/2023
 * @project
 */

public interface OrderReportInterface {
    LocalDate getDate();
    Long getTotalOrder();
    Double getTotalOrderAmount();
}
