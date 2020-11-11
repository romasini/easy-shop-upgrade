package ru.romasini.easy.shop.upgrade.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.upgrade.entities.Order;
import ru.romasini.easy.shop.upgrade.entities.OrderItem;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.repositories.OrderRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Page<Order> findAll(Integer numPage, int sizePage){
        return orderRepository.findAll(PageRequest.of(numPage, sizePage));
    }

    public Page<Order> findAllByUser(User user, Integer numPage, int sizePage){
        return orderRepository.findAllByUser(user, PageRequest.of(numPage, sizePage));
    }

    public Page<Order> findAllByUsername(String username, Integer numPage, int sizePage){
        return orderRepository.findAllByUsername(username, PageRequest.of(numPage, sizePage));
    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    public Optional<Order> findByIdAndUsername(Long id, String username){
        return orderRepository.findByIdAndUsername(id, username);
    }

    public Order save(Order order){
        for (OrderItem oi: order.getItems()){
            oi.setOrder(order);
        }

        return orderRepository.save(order);

    }

}
