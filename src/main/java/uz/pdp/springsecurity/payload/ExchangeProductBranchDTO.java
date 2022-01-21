package uz.pdp.springsecurity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springsecurity.entity.ExchangeProduct;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeProductBranchDTO {

    private Integer shippedBranchId;

    private List<Integer> receivedBranch;

    private Date exchangeDate;

    private String description;

    private List<ExchangeProductDTO> exchangeProductDTOS;

}
