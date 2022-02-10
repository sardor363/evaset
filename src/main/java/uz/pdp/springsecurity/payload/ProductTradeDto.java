package uz.pdp.springsecurity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTradeDto {

    @NotNull(message = "required line")
    private Double tradedQuantity;

    @NotNull(message = "required line")
    private Integer productTradeId;

}
