package com.study.shoppingmall.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/{id}")
    public Product findProductsById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

}
