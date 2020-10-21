package ru.romasini.easy.shop.upgrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.romasini.easy.shop.upgrade.utils.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CartDto {
    private List<OrderItemDto> items;
    private Integer amount;

    public CartDto(Cart cart) {
        this.amount = cart.getAmount();
        this.items = cart.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }

}
