package ru.davydchekov;
/**
 * Задание:
 * 1) На базе первого примера разобранного на семинаре,
 * добавить в один из проектов разработанных ранее spring Integration.
 * Сохранять запросы от пользователя в файл.
 * 2) Добавить в проект один из паттернов разобранных на лекции.
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttestationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttestationApplication.class, args);
	}

}
