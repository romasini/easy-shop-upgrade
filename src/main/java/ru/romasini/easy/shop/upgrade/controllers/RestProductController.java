package ru.romasini.easy.shop.upgrade.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.upgrade.entities.Product;
import ru.romasini.easy.shop.upgrade.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.upgrade.services.ProductService;
import ru.romasini.easy.shop.upgrade.utils.ProductFilter;

import java.util.Map;

@RequestMapping("/api/v1/products")
@RestController
@AllArgsConstructor
public class RestProductController {

    private static final int PAGE_SIZE = 5;
    private ProductService productService;

    @GetMapping
    public Page<Product> productsList(
            @RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage,
            @RequestParam Map<String, String> params){
        if(numPage <= 0){
            numPage = 1;
        }
        ProductFilter productFilter = new ProductFilter(params);
        return productService.findAll(productFilter.getSpec(), numPage-1, PAGE_SIZE);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Product createProduct(@RequestBody Product p) {
        //p.setId(null);
        return productService.save(p);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Product updateProduct(@RequestBody Product p) {
        return productService.save(p);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}
