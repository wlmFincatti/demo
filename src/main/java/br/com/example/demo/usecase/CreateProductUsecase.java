package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.domain.product.exception.ProductNameExistsException;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductUsecase {

    private final ProductGateway gateway;

    @Caching(evict = {@CacheEvict(value = "product", allEntries = true)}
        , put = {@CachePut(value = "product", key = "#product.getId()")})
    public Product execute(Product product) {

        gateway.findProductByName(product.getName())
            .ifPresent(p -> {
                throw new ProductNameExistsException(p.getName());
            });

        return gateway.createProduct(product);
    }

}
