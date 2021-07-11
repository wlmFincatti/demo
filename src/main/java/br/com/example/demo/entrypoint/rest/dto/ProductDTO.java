package br.com.example.demo.entrypoint.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDTO {

    @NotEmpty(message = "name required field")
    @Schema(name = "name", description = "name of product", example = "item", type = "string")
    private String name;

    @NotNull(message = "price required field")
    @Schema(name = "price", description = "price of product", example = "12.00", type = "number")
    private BigDecimal price;

}
