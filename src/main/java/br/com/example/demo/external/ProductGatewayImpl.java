package br.com.example.demo.external;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.external.repository.ProductRepository;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository repository;

    @Override
    public Optional<Product> findProductById(String id) {
        return repository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void deleteProductById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Page<Product> findAllProduct(Integer page, Integer pageSize, Sort fieldSort) {
        return repository.findAll(PageRequest.of(page, pageSize, fieldSort));
    }

}
