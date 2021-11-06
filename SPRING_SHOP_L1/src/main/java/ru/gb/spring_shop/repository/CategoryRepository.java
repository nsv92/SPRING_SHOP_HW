package ru.gb.spring_shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.categories.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
