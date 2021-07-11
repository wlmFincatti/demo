package br.com.example.demo;

import br.com.example.demo.domain.product.Product;
import br.com.example.demo.external.repository.ProductRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.stream.IntStream;

@EnableCaching
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void initCollection() {
        IntStream.range(0, 200)
            .forEach(idx -> {
                Product ps5 = Product
                    .builder()
                    .name(String.format("item_%d", idx))
                    .price(BigDecimal.valueOf(RandomUtils.nextFloat()))
                    .build();

                repository.save(ps5);
            });
    }

}
