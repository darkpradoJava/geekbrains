package java1.homework5;

/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников
* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
* */

public class Worker {

    private String name, position, email;
    private int phone, age;

    Worker (String name, String position, String email, int phone, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", position: " + position + ", email: " + email + ", phone: " + phone + ", age: " + age;
    }

    public int getAge() {
        return age;
    }

}
