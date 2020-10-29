package ru.romasini.easy.shop.upgrade.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.romasini.easy.shop.upgrade.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findAllByPriceGreaterThanEqual(Integer minPrice, Pageable page);
    Page<Product> findAllByPriceLessThanEqual(Integer maxPrice, Pageable page);
    Page<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(Integer minPrice, Integer maxPrice, Pageable page);
    //Page<Product> findAllByCategoryIdIn(List<Long> ids, Pageable page);

}
