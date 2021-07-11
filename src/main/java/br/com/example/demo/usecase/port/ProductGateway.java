package br.com.example.demo.usecase.port;

import br.com.example.demo.domain.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {

    Optional<Product> findProductById(String id);

    Product createProduct(Product product);

    Optional<Product> findProductByName(String name);

    void deleteProductById(String id);

    Product updateProduct(Product product);

    Page<Product> findAllProduct(Integer page, Integer pageSize, Sort fieldSort);

    List<Product> findProduct(Product product);
}
