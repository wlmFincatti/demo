package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.domain.product.exception.ProductNotFoundException;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindProductByIdUsecase {

    private final ProductGateway gateway;

    @CachePut(value = "product", key = "#id")
    public Product execute(String id) {
        return gateway.findProductById(id)
            .orElseThrow(() -> {
                log.error("product not found with id {}", id);
                return new ProductNotFoundException("id", id);
            });
    }

}
