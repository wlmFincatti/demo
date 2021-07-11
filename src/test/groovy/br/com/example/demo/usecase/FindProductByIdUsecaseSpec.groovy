package br.com.example.demo.usecase

import br.com.example.demo.domain.product.Product
import br.com.example.demo.usecase.port.ProductGateway
import spock.lang.Specification

class FindProductByIdUsecaseSpec extends Specification {

    ProductGateway gateway
    FindProductByIdUsecase findProductByIdUsecase

    void setup() {
        gateway = Mock()
        findProductByIdUsecase = new FindProductByIdUsecase(gateway)
    }

    void cleanup() {
    }

    def "should find product by id"() {
        given: "have one id"
        def id = UUID.randomUUID().toString()
        def productMock = Product
                .builder()
                .id(id)
                .price(new BigDecimal("12.00"))
                .name("item")
                .build()

        when: "call method execute"
        def result = findProductByIdUsecase.execute(id)

        then: "valid if gateay calls once time"
        1 * gateway.findProductById(id) >> Optional.of(productMock)
        and: "make assertions in result"
        assert id == result.id
        assert "item" == result.name
        assert 12F == result.price
    }
}
