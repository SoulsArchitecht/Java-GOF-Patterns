package gof_patterns.Pattern16_Prototype;

public class DeepCloneBestPracticeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        PersonAddress personAddress = new PersonAddress("Lenin", 32);
        Persona persona = new Persona("Nick", 25, personAddress);
        Persona persona1 = new Persona(persona);

        System.out.println(!persona.equals(persona1));
        System.out.println(persona.name.equals(persona1.name));
        System.out.println(persona.personAddress.street.equals(persona1.personAddress.street));

        persona.name = "Tom";
        persona.personAddress.street = "Marks";

        System.out.println(persona1.name);
        System.out.println(persona1.personAddress.street);

    }
}

class PersonAddress implements Cloneable {
    String street;
    int number;

    public PersonAddress(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public PersonAddress (PersonAddress personAddress) {
        this.street = personAddress.street;
        this.number = personAddress.number;
    }

    @Override
    protected PersonAddress clone() throws CloneNotSupportedException {
        return (PersonAddress) super.clone();
    }
}

class Persona implements Cloneable {
    String name;
    int age;
    PersonAddress personAddress;

    public Persona(String name, int age, PersonAddress personAddress) {
        System.out.println("constructor1");
        this.name = name;
        this.age = age;
        this.personAddress = personAddress;
    }

    public Persona (Persona persona) {
        System.out.println("constructor2");
        this.name = persona.name;
        this.age = persona.age;
        this.personAddress = new PersonAddress(persona.personAddress);
    }

}
