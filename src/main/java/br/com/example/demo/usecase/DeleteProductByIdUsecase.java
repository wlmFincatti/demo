package br.com.example.demo.usecase;

import br.com.example.demo.usecase.port.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteProductByIdUsecase {

    private final ProductGateway gateway;
    private final FindProductByIdUsecase findProductByIdUsecase;

    public void execute(String id) {
        findProductByIdUsecase.execute(id);
        gateway.deleteProductById(id);
    }

}
