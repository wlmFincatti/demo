package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.domain.product.exception.ProductNotFounException;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindProductByNameUsecase {

    private final ProductGateway gateway;

    public Product execute(String name) {
        return gateway.findProductByName(name)
            .orElseThrow(() -> {
                log.error("product with name {} exists", name);
                return new ProductNotFounException("name", name);
            });
    }

}
