package ru.romasini.easy.shop.upgrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.romasini.easy.shop.upgrade.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private String categoryTitle;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.price = p.getPrice();
        this.categoryTitle = p.getCategory().getTitle();
    }
}
