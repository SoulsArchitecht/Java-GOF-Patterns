package gof_patterns.Pattern16_Prototype;

/** Прототип (Prototype) — это порождающий паттерн проектирования, который позволяет копировать объекты,
не вдаваясь в подробности их реализации. Часто используется при работе с БД, чтобы повторно
 к ним не обращаться лишний раз*/



//simple clone example
public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("Mike", 22);
        Person person2 = person1.clone();

        System.out.println(person1 != person2);
        System.out.println(person1.name == person2.name);
    }
}

class Person implements Cloneable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
