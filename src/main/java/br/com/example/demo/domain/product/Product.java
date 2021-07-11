package br.com.example.demo.domain.product;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Data
@Document(collection = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 2038666175199554949L;
    
    @Id
    private String id;
    private String name;
    private BigDecimal price;

}
