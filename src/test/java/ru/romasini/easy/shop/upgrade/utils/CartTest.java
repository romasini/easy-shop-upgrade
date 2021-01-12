package ru.romasini.easy.shop.upgrade.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Cart.class)
public class CartTest {

    @Autowired
    private Cart cart;

    @Test
    public void cartFillingTest(){

    }

    //TODO
    //тест корзины
}
