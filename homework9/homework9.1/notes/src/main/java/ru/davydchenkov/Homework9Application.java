package ru.davydchenkov;
/**
 * Базовое задание:
 * Добавить в один из Ваших проектов сделанных ранее ApiGateWay и Eureka. В проекте обязательно должна быть Spring Data.
 * Задание со звездочкой:
 * В проект так же добавить spring config server
 * Связь между микросервисами перевести на spring cloud openfeign
 * _
 * Это не задание, но если найдете пример подключения spring hystrix на версии Spring 3 всем студентам обязательно покажем на следующем семинаре.*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homework9Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework9Application.class, args);
	}

}
