package ru.romasini.easy.shop.upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyShopUpgradeApplication {
	//application-h2
	//VM options -Dspring.profiles.active=h2
	//V1__ ДВА нижних подчеркивания


	// Домашнее задание:
	// 1. Добавить выгрузку всех продуктов через SOAP
	// 2. * Добавить выгрузку заказов пользователя по его имени (защиту не ставим пока)

	//Вопрос
	//1) В контроллере ProfileController текущий профиль получаю из текущего пользователя через user.getProfile().
	// При редактировании профиля также получаю его из текущего пользователя. Насколько это корректно?
	// Вроде не безопасно, но перед корректировкой производится проверка пароля.


	public static void main(String[] args) {
		SpringApplication.run(EasyShopUpgradeApplication.class, args);
	}

}

//TODO
//переход на список заказов после оформления заказа урок 4 45
//карточка товара для покупателя
//неавторизованный доступ к карточке товара (просмотр)
//регистрация пользователя


