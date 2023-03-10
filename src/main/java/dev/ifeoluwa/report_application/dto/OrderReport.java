package dev.ifeoluwa.report_application.dto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author on 10/03/2023
 * @project
 */
@Data
@NoArgsConstructor
//@SqlResultSetMapping(
//        name = "OrderReportMapping",
//        classes = @ConstructorResult(
//                targetClass = OrderReport.class,
//                columns = {
//                        @ColumnResult(name = "date", type = LocalDate.class),
//                        @ColumnResult(name = "total_order", type = Long.class),
//                        @ColumnResult(name = "total_order_amount", type = Double.class)
//                }
//        )
//)
public class OrderReport  {
    private LocalDate date;
    private Long total_order;
    private Double total_order_amount;

    public OrderReport(LocalDate date, Long total_order, Double total_order_amount) {
        this.date = date;
        this.total_order = total_order;
        this.total_order_amount = total_order_amount;
    }


}
