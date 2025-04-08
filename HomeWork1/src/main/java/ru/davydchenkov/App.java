package ru.davydchenkov;

import com.google.gson.Gson;

/**
 * Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
 * Задание:
 * 1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
 * 2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
 * 3. Создайте класс Person с полями firstName, lastName и age.
 * 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
 * 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();

        Person person = new Person("Иван", "Иванов",40, 89992223344L);
        Person person2 = new Person("Иван", "Иванов",40, 89992223344L);
        Person person3 = new Person("Боря>", "Борисов",35, 89993333344L);

        System.out.println(person.equals(person2));
        System.out.println(person.equals(person3));
        System.out.println(person.hashCode());
        System.out.println(person.toString());
        System.out.println("======================================================");

        String jsonStringWrite = gson.toJson(person);
        System.out.println("Сериализованный объект класса Person: " + jsonStringWrite);
        System.out.println("======================================================");

        String jsonStringRead = String.valueOf(gson.fromJson(jsonStringWrite, Person.class));
        System.out.println("Десериализованный объект класса Person: " + jsonStringRead);


    }
}
