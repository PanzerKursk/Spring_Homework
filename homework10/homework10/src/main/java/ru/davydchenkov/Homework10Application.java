package ru.davydchenkov;
/**
 * Базовое задание:
 * По аналогии с примерами показанными на семинаре, добавить модульное тестирование и интеграционное для одного из своих проектов(так же протестировать один из методов сервиса).
 * Задание со звездочкой:
 * Для своего многомодульного проекта добавить модульные тесты и интеграционное тестирование на сценарии резервирования товара на складе и оплаты товара(4 теста). А так же добавить нагрузочное тестирование на всю систему(без WEB части) покупки товара в целом.
 * Нагрузочное тестирование сдается файлом настройки тестирования для программы JMETER.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homework10Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework10Application.class, args);
	}

}
