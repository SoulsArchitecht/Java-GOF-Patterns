package gof_patterns.Pattern22_Visitor;

/**
 * Посетитель (Visitor) — это поведенческий паттерн проектирования, который позволяет добавлять
 * в программу новые операции, не изменяя классы объектов, над которыми эти операции могут выполняться.
 */

public class VisitorExample {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Animal animal1 = new Cat();
        animal.accept(new SoundVisitor());
        animal1.accept(new SoundVisitor());

        animal.accept(new EatVisitor());
        animal1.accept(new EatVisitor());
    }
}

interface Animal {
    void accept(AnimalVisitor animalVisitor);
}

interface AnimalVisitor {
    void action(Animal animal);
    // в оригинале зачем то для каждого животного
    // void action(Dog dog);
    // void action(Cat cat);

}

class Dog implements Animal {

    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Cat implements Animal {

    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class SoundVisitor implements AnimalVisitor {

    @Override
    public void action(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println("wof");
        } else if (animal instanceof Cat) {
            System.out.println("mao");
        }
    }

    // в оригинале 2 метода, каждый для своего животного
}

class EatVisitor implements AnimalVisitor {

    @Override
    public void action(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println("meat for dog");
        } else if (animal instanceof Cat) {
            System.out.println("fish for cat");
        }
    }

    // в оригинале 2 метода, каждый для своего животного
}