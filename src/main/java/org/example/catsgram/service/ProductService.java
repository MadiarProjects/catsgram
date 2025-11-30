package org.example.catsgram.service;

import org.example.catsgram.model.Product;
import org.example.catsgram.model.ProductType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = List.of(
            new Product("Яблоко", 450, ProductType.FRUIT),
            new Product("Банан", 700, ProductType.FRUIT),
            new Product("Морковь", 300, ProductType.VEGETABLE),
            new Product("Помидор", 600, ProductType.VEGETABLE),
            new Product("Апельсин", 800, ProductType.FRUIT),
            new Product("Огурец", 400, ProductType.VEGETABLE),
            new Product("Виноград", 1200, ProductType.FRUIT),
            new Product("Картофель", 200, ProductType.VEGETABLE),
            new Product("Говядина", 4500, ProductType.MEAT),
            new Product("Курица", 2000, ProductType.MEAT),
            new Product("Свинина", 3000, ProductType.MEAT),
            new Product("Молоко", 500, ProductType.DAIRY),
            new Product("Сыр", 1500, ProductType.DAIRY),
            new Product("Йогурт", 800, ProductType.DAIRY)
    );
    private Integer size;
    private Integer page;

//    public List<Product> getByPageAndSize(Integer page, Integer size) {
//
//
//    }

    public List<Product> findAll(Integer minPrice, Integer maxPrice, List<ProductType> types) {
        return products.stream()
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .filter(p -> types == null || types.contains(p.getType()))
                .toList();
    }
}
