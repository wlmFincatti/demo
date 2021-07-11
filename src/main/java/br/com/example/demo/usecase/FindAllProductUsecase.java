package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class FindAllProductUsecase {

    private final ProductGateway gateway;

    public Page<Product> execute(Integer page, Integer pageSize, Sort fieldSort) {
        return gateway.findAllProduct(page, pageSize, fieldSort);
    }

}
