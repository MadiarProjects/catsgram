package org.example.catsgram.controller;

import lombok.RequiredArgsConstructor;
import org.example.catsgram.exception.ErrorResponce;
import org.example.catsgram.exception.NotFoundedException;
import org.example.catsgram.model.Product;
import org.example.catsgram.model.ProductType;
import org.example.catsgram.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
//    @GetMapping("/products")
//    public List<Product> findAll(@RequestParam(required = false)Integer minPrice,
//                                 @RequestParam(required = false)Integer maxPrice,
//                                 @RequestParam(required = false)List<ProductType> types){
//        return productService.findAll(minPrice,maxPrice,types);
//    }
    @GetMapping("/products")
    public List<Product> getByPageAndSize(@RequestParam int page,
                                          @RequestParam int size){
        return productService.getByPageAndSize(page,size);
    }

    // /products?minPrice=500&maxPrice=800&type=FRUIT   - получить все ФРУКТЫ от 500 до 800
    // /products?minPrice=500&maxPrice=800              - получить все товары от 500 до 800
    // /products?minPrice=500                           - получить все товары от 500
    // /products?maxPrice=800                           - получить все товары до 800
    // /products                                        - получить все товары
}