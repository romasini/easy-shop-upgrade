package ru.romasini.easy.shop.upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyShopUpgradeApplication {
	//application-h2
	//VM options -Dspring.profiles.active=h2
	//V1__ ДВА нижних подчеркивания

	// Домашнее задание:
	// 1. Личный кабинет пользователя с отображением профиля (имя, фамилия, телефон, email, год рождения, пол, город проживания)
	// 2. Дать возможность изменять профиль (с подтверждением паролем)


	public static void main(String[] args) {
		SpringApplication.run(EasyShopUpgradeApplication.class, args);
	}

}

//TODO
//неавторизованный доступ к карточке товара (просмотр)
//регистрация пользователя
//оформление заказа
//добавить профили клиента
//редактирование профиля
//форма отдельного заказа


