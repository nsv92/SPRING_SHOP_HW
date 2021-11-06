package ru.gb.spring_shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.products.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
