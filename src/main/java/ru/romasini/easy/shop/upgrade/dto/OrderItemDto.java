package ru.romasini.easy.shop.upgrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.romasini.easy.shop.upgrade.entities.OrderItem;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private Integer quantity;
    private Integer pricePerProduct;
    private Integer price;

    public OrderItemDto(OrderItem o) {
        this.productId = o.getProduct().getId();
        this.productTitle = o.getProduct().getTitle();
        this.quantity = o.getQuantity();
        this.pricePerProduct = o.getPricePerProduct();
        this.price = o.getPrice();
    }

}
