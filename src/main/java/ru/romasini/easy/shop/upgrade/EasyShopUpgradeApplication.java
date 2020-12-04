package ru.romasini.easy.shop.upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyShopUpgradeApplication {
	//application-h2
	//VM options -Dspring.profiles.active=h2
	//V1__ ДВА нижних подчеркивания

//1 37
	// Домашнее задание:
	// 1. Добавить выгрузку всех продуктов через SOAP
	// 2. * Добавить выгрузку заказов пользователя по его имени (защиту не ставим пока)




	public static void main(String[] args) {
		SpringApplication.run(EasyShopUpgradeApplication.class, args);
	}

}

//TODO
//переход на список заказов после оформления заказа урок 4 45
//карточка товара для покупателя
//неавторизованный доступ к карточке товара (просмотр)
//регистрация пользователя


