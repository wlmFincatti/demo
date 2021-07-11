package br.com.example.demo.adapter;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.entrypoint.rest.dto.ProductDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Productdapter {

    public static ProductDTO convertToResponse(Product product) {
        return ProductDTO
            .builder()
            .name(product.getName())
            .price(product.getPrice())
            .build();
    }

    public static Product convertToDomain(ProductDTO productDto) {
        return Product
            .builder()
            .name(productDto.getName())
            .price(productDto.getPrice())
            .build();
    }

    public static Page<ProductDTO> convertToPageResponse(Page<Product> productsPage) {

        List<ProductDTO> productsDto = productsPage
            .get()
            .map(Productdapter::convertToResponse)
            .collect(Collectors.toList());

        return new PageImpl<ProductDTO>(
            productsDto,
            productsPage.getPageable(),
            productsPage.getTotalElements());
    }

}
