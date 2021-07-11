package br.com.example.demo.usecase;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.usecase.port.ProductGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindProductByIdUsecaseTest {

    private ProductGateway gateway;
    private FindProductByIdUsecase findProductByIdUsecase;


    @BeforeEach
    void setUp() {
        gateway = mock(ProductGateway.class);
        findProductByIdUsecase = new FindProductByIdUsecase(gateway);
    }

    @Test
    void shouldFindProductById() {
        //given
        String id = UUID.randomUUID().toString();
        BigDecimal price = new BigDecimal("12.00");
        String item = "item";
        Product productMock = Product
            .builder()
            .id(id)
            .price(price)
            .name(item)
            .build();
        when(gateway.findProductById(id)).thenReturn(Optional.of(productMock));

        //when
        Product result = findProductByIdUsecase.execute(id);

        //then
        verify(gateway, times(1)).findProductById(id);
        assertEquals(id, result.getId());
        assertEquals(item, result.getName());
        assertEquals(price, result.getPrice());
    }
}