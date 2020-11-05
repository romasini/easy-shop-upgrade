package ru.romasini.easy.shop.upgrade.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.romasini.easy.shop.upgrade.entities.Order;
import ru.romasini.easy.shop.upgrade.entities.User;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAllByUser(User user, Pageable pageable);

//    @Query( value = "select * from orders o where o.user_id in (select u.id from users u where u.username = ?1)",
//            countQuery = "select count(*) from orders o where o.user_id in (select u.id from users u where u.username = ?1)",
//            nativeQuery = true)
//    Page<Order> findAllByUsername(String username, Pageable pageable);

    @Query("select o from Order o where o.user.username = ?1")
    Page<Order> findAllByUsername(String username, Pageable pageable);

    @Query("select o from Order o where o.id = ?1 and o.user.username = ?2")
    Optional<Order> findByIdAndUsername(Long id, String username);
}
