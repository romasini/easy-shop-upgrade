package ru.romasini.easy.shop.upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyShopUpgradeApplication {
	//application-h2
	//VM options -Dspring.profiles.active=h2
	//V1__ ДВА нижних подчеркивания

	// Домашнее задание:
	// 1. Оформление заказов
	// 2. Попробуйте сделать регистрацию новых пользователей без валидации

	public static void main(String[] args) {
		SpringApplication.run(EasyShopUpgradeApplication.class, args);
	}

}
