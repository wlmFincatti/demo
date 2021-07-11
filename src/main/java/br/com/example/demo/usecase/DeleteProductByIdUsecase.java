package br.com.example.demo.usecase;

import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteProductByIdUsecase {

    private final ProductGateway gateway;
    private final FindProductByIdUsecase findProductByIdUsecase;

    @CacheEvict(cacheNames = "Product", allEntries = true)
    public void execute(String id) {
        findProductByIdUsecase.execute(id);
        gateway.deleteProductById(id);
    }

}
