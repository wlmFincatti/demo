package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateProductUsecase {

    private final ProductGateway gateway;
    private final FindProductByIdUsecase findProductByIdUsecase;

    @Caching(evict = {@CacheEvict(value = "product", allEntries = true)}
        , put = {@CachePut(value = "product", key = "#id")})
    public Product execute(String id, Product product) {

        Product productFound = findProductByIdUsecase.execute(id);
        productFound.setName(product.getName());
        productFound.setPrice(product.getPrice());

        return gateway.updateProduct(productFound);
    }

}
