package ru.romasini.easy.shop.upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyShopUpgradeApplication {
	//application-h2
	//VM options -Dspring.profiles.active=h2
	//V1__ ДВА нижних подчеркивания

	// Домашнее задание:
	// 1. Добавьте категории для продуктов
	// 2. Сделайте на фронтенде фильтр по категориям (выпадающий список с категориями)
	// 3. * Вместо пункта 2 сделайте фильтр по нескольким категориям (1+)

	public static void main(String[] args) {
		SpringApplication.run(EasyShopUpgradeApplication.class, args);
	}

}
