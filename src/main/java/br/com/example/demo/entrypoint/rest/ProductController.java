package br.com.example.demo.entrypoint.rest;

import br.com.example.demo.adapter.Productdapter;
import br.com.example.demo.domain.product.Product;
import br.com.example.demo.entrypoint.rest.dto.ErrorResponse;
import br.com.example.demo.entrypoint.rest.dto.ErrorWrapperResponse;
import br.com.example.demo.entrypoint.rest.dto.ProductDTO;
import br.com.example.demo.entrypoint.rest.routes.ProductRoutes;
import br.com.example.demo.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
            @Parameter(name = "page", description = "number of page required", example = "10", in = ParameterIn.QUERY),
            @Parameter(name = "size", description = "number of records per page", example = "10", in = ParameterIn.QUERY),
            @Parameter(name = "sort", description = "field sorted of object Product", example = "name", in = ParameterIn.QUERY)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Return list of products pageable"),
            @ApiResponse(responseCode = "500", description = "Internal error")
        }
    )
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(
        @Parameter(hidden = true) @PageableDefault(sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {

        return ResponseEntity
            .ok(Productdapter.convertToPageResponse(findAllProductUsecase.execute(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSort())));
    }

    @Operation(
        summary = "Find product by id",
        description = "Method to find product by id",
        parameters = @Parameter(name = "id", in = ParameterIn.PATH),
        responses = {
            @ApiResponse(responseCode = "200", description = "Return product"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(name = "ErrorResponse", description = " Error response object",
                        implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error")
        }
    )
    @GetMapping(path = ProductRoutes.BY_ID)
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return ResponseEntity
            .ok(Productdapter.convertToResponse(findProductByIdUsecase.execute(id)));
    }


    @Operation(
        summary = "Create product",
        description = "Method to create a new product",
        responses = {
            @ApiResponse(responseCode = "201", description = "Create product"),
            @ApiResponse(responseCode = "400", description = "Invalid fields in request body",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(name = "ErrorWrapperResponse", description = " Error response object",
                        implementation = ErrorWrapperResponse.class))),
            @ApiResponse(responseCode = "422", description = "Product with name exists",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(name = "ErrorResponse", description = " Error response object",
                        implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error")
        }
    )
    @PostMapping
    public ResponseEntity<ProductDTO> createProductById(@Valid @RequestBody ProductDTO productDto,
                                                        HttpServletResponse response) {

        final Product newProduct = createProductUsecase.execute(Productdapter.convertToDomain(productDto));
        URI uri = UriComponentsBuilder
            .fromPath(ProductRoutes.BASE_PATH_PRODUCT.concat(ProductRoutes.BY_ID))
            .buildAndExpand(newProduct.getId())
            .toUri();

        return ResponseEntity
            .created(uri)
            .body(Productdapter.convertToResponse(newProduct));
    }

    @Operation(
        summary = "Delete product by id",
        description = "Method to delete a product by id",
        parameters = @Parameter(name = "id", in = ParameterIn.PATH),
        responses = {
            @ApiResponse(responseCode = "204", description = "Delete product"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(name = "ErrorResponse", description = " Error response object",
                        implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error")
        }
    )
    @DeleteMapping(path = ProductRoutes.BY_ID)
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {

        deleteProductByIdUsecase.execute(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Update product",
        description = "Method to update product passing id",
        parameters = @Parameter(name = "id", in = ParameterIn.PATH),
        responses = {
            @ApiResponse(responseCode = "200", description = "Update product with id"),
            @ApiResponse(responseCode = "400", description = "Invalid fields in request body",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(name = "ErrorWrapperResponse", description = " Error response object",
                        implementation = ErrorWrapperResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(name = "ErrorResponse", description = " Error response object",
                        implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal error")
        }
    )
    @PutMapping(path = ProductRoutes.BY_ID)
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id,
                                                    @Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity
            .ok(Productdapter.convertToResponse(updateProductUsecase.execute(id, Productdapter.convertToDomain(productDTO))));
    }

}
