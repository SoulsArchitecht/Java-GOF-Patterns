package gof_patterns.Pattern16_Prototype;

// deep copy cloning bad practice
public class DeepCloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Lenin", 33);
        Person2 person21 = new Person2("John", 25, address);
        Person2 person22 = person21.clone();

        System.out.println(person21 == person22);
        System.out.println(person21.name == person22.name);
        System.out.println(person21.address.street == person22.address.street);

        person21.name = "Alex";
        person21.address.street = "Peace";
        System.out.println(person22.name);
        System.out.println(person22.address.street);
    }
}

class Address implements Cloneable {
    String street;
    int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}

class Person2 implements Cloneable {
    String name;
    int age;
    Address address;

    public Person2(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    protected Person2 clone() throws CloneNotSupportedException {
        Person2 person2 = (Person2) super.clone();
        person2.address = this.address.clone();
        return person2;
    }
}
