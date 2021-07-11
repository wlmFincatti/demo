package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.entrypoint.rest.dto.ProductDTO;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateProductUsecase {

    private final ProductGateway gateway;
    private final FindProductByIdUsecase findProductByIdUsecase;

    public Product execute(String id, ProductDTO productDto) {

        Product productFound = findProductByIdUsecase.execute(id);
        productFound.setName(productDto.getName());
        productFound.setPrice(productDto.getPrice());

        return gateway.updateProduct(productFound);
    }

}
