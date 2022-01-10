package gof_patterns.Pattern3_Builder;

/** Паттерн необходим тогда, когда нам нужно создавать экземпляры класса с разным
количеством полей класса.
 Для этого нам необходимо множество конструкторов.
 Чтобы их не создавать и существует концепция Builder*/

public class BuilderTestSample {
    public static void main(String[] args) {
        Person person1 = new PersonBuilderImpl().setName("Nike").setAge(30).build();
        Person person2 = new PersonBuilderImpl().setName("Jack").setSalary(2000).build();
        System.out.println(person1);
        System.out.println(person2);
    }
}

class Person {
    String name;
    int age;
    double salary;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

interface PersonBuilder {
    PersonBuilder setName(String name);
    PersonBuilder setAge(int age);
    PersonBuilder setSalary(double salary);
    Person build();
}

class PersonBuilderImpl implements PersonBuilder {
    Person person = new Person();


    @Override
    public PersonBuilder setName(String name) {
        person.name = name;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        person.age = age;
        return this;
    }

    @Override
    public PersonBuilder setSalary(double salary) {
        person.salary = salary;
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}
