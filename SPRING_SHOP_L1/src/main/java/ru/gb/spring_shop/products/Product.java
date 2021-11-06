package ru.gb.spring_shop.products;

import lombok.Data;
import ru.gb.spring_shop.categories.Category;

import javax.persistence.*;
import java.util.List;

@Table(name = "products")
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "categories_products",
                joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories;

    public Product() {
    }

    public Product(Long id, String name, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }
}