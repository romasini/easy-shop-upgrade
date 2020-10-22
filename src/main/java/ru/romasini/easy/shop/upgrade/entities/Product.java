package ru.romasini.easy.shop.upgrade.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

//    @Column(name = "category_id")
//    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
