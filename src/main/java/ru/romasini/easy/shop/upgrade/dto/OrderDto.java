package ru.romasini.easy.shop.upgrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import ru.romasini.easy.shop.upgrade.entities.Order;
import ru.romasini.easy.shop.upgrade.entities.OrderItem;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.utils.Cart;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String username;
    private String name;
    private String phone;
    private String address;
    private Integer price;
    private List<OrderItemDto> items;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.username = order.getUser().getUsername();
        this.name = order.getName();
        this.phone = order.getPhone();
        this.address = order.getAddress();
        this.price = order.getPrice();
        this.items = order.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }
}
