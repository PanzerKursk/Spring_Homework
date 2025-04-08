package ru.davydchenkov;

import java.util.Objects;

public class Person {
    private String firstname;
    private String lastname;
    private Integer age;
    private Long phone;

    public Person(String firstname, String lastname, Integer age, Long phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public Long getPhone() {
        return phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Person person = (Person) obj;
        return (person.firstname.equals(this.firstname) && person.lastname.equals(this.lastname) && person.age == this.age);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getFirstname()).append(" ")
                .append(getLastname()).append(" ")
                .append(getAge()).append(" ")
                .append(getPhone()).append(" ")
                .toString();
    }
}
