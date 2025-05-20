package abdumalik.dev.myway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private String name;
    private Double price;
    private Integer monthsPayment;
    private Double pricePerMonth;

}