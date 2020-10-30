package ru.romasini.easy.shop.upgrade.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.upgrade.dto.OrderDto;
import ru.romasini.easy.shop.upgrade.entities.Order;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.upgrade.services.OrderService;
import ru.romasini.easy.shop.upgrade.services.UserService;
import ru.romasini.easy.shop.upgrade.utils.Cart;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final Cart cart;
    private final UserService userService;

    @PostMapping
    public String addNewOrder(@RequestBody Order order, Principal principal){
        order.setItems(cart.getItems());
        User user = userService.findByUsername(principal.getName());
        order.setUser(user);
        orderService.save(order);
        cart.init();
        return "Заказ сохранен № " + order.getId();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public OrderDto getOrderById(@PathVariable Long id){
        Order order = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id));
        return new OrderDto(order);
    }

}
