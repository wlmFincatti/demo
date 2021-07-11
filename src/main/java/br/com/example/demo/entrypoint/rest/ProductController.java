package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.adapter.Productdapter;
import br.com.example.demo.domain.product.Product;
import br.com.example.demo.entrypoint.rest.dto.ProductDTO;
import br.com.example.demo.entrypoint.rest.routes.ProductRoutes;
import br.com.example.demo.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = ProductRoutes.BASE_PATH_PRODUCT)
public class ProductController {

    private final FindProductByIdUsecase findProductByIdUsecase;
    private final CreateProductUsecase createProductUsecase;
    private final FindAllProductUsecase findAllProductUsecase;
    private final DeleteProductByIdUsecase deleteProductByIdUsecase;
    private final UpdateProductUsecase updateProductUsecase;

    @Operation(
        summary = "Find all products",
        description = "Method to find all products",
        parameters = {
            @Parameter(name = "page", in = ParameterIn.QUERY),
            @Parameter(name = "size", in = ParameterIn.QUERY),
            @Parameter(name = "sort", in = ParameterIn.QUERY)
        })
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(
        @Parameter(hidden = true) @PageableDefault(sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {

        return ResponseEntity
            .ok(Productdapter.convertToPageResponse(findAllProductUsecase.execute(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort())));
    }

    @GetMapping(path = ProductRoutes.BY_ID)
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return ResponseEntity
            .ok(Productdapter.convertToResponse(findProductByIdUsecase.execute(id)));
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProductById(@RequestBody ProductDTO productDto, HttpServletResponse response) {

        final Product newProduct = createProductUsecase.execute(Productdapter.convertToDomain(productDto));
        URI uri = UriComponentsBuilder
            .fromPath(ProductRoutes.BASE_PATH_PRODUCT.concat(ProductRoutes.BY_ID))
            .buildAndExpand(newProduct.getId())
            .toUri();

        return ResponseEntity
            .created(uri)
            .body(Productdapter.convertToResponse(newProduct));
    }

    @DeleteMapping(path = ProductRoutes.BY_ID)
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {

        deleteProductByIdUsecase.execute(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = ProductRoutes.BY_ID)
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity
            .ok(Productdapter.convertToResponse(updateProductUsecase.execute(id, productDTO)));
    }

}
