package org.example.catsgram.service;

import org.example.catsgram.exception.ErrorResponce;
import org.example.catsgram.exception.NotFoundedException;
import org.example.catsgram.model.Product;
import org.example.catsgram.model.ProductType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Product> getByPageAndSize(int page, int size) {
        int start = (page - 1) * size;
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = start + i;
            if (index < products.size()) {
                result.add(products.get(index));
            } else {
                result.add(null);
            }
        }
        if (result.stream().allMatch(Objects::isNull)){
            throw new NotFoundedException("на "+page+" странице нет объектов");
        }

        return result;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponce notFoundedException(NotFoundedException e){
        return new ErrorResponce(e.getMessage());
    }
    public List<Product> findAll(Integer minPrice, Integer maxPrice, List<ProductType> types) {
        return products.stream()
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .filter(p -> types == null || types.contains(p.getType()))
                .toList();
    }
}
