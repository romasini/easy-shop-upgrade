package ru.romasini.easy.shop.upgrade.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.upgrade.dto.OrderDto;
import ru.romasini.easy.shop.upgrade.entities.Order;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.upgrade.services.OrderService;
import ru.romasini.easy.shop.upgrade.services.UserService;
import ru.romasini.easy.shop.upgrade.utils.Cart;

import java.security.Principal;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private static final int PAGE_SIZE = 5;
    private final OrderService orderService;
    private final Cart cart;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewOrder(@RequestParam String name,
                            @RequestParam String phone,
                            @RequestParam String address,
                              Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found", principal.getName())));

        Order order = new Order();
        order.setUser(user);
        order.setName(name);
        order.setPhone(phone);
        order.setAddress(address);
        order.setItems(cart.getItems());
        order.setPrice(cart.getAmount());

        orderService.save(order);
        cart.init();

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public OrderDto getOrderById(@PathVariable Long id, Principal principal){
        Order order = orderService.findByIdAndUsername(id, principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Unable to find order with id: " + id));
        return new OrderDto(order);
    }

    @GetMapping
    public Page<OrderDto> getAllOrders(
            @RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage,
            Principal principal){
        Page<Order> orders = orderService.findAllByUsername(principal.getName(), numPage-1, PAGE_SIZE);
        Page<OrderDto> oo = new PageImpl<>(orders.getContent().stream().map(OrderDto::new).collect(Collectors.toList()), orders.getPageable(), orders.getTotalElements());
        return oo;
    }

}
