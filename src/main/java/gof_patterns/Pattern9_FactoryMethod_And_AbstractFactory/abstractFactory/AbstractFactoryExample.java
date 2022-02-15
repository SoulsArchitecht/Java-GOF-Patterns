package gof_patterns.Pattern9_FactoryMethod_And_AbstractFactory.abstractFactory;

/**Абстрактная фабрика (Abstract Factory) — это порождающий паттерн проектирования, который
 * позволяет создавать семейства связанных объектов, не привязываясь к конкретным классам
 * создаваемых объектов.*/

public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new MercedesFactory();
        Truck newTruck1 = abstractFactory.getTruck();
        Bike newBike2 = abstractFactory.getBike();
        newTruck1.drive();
        newBike2.drive();

        System.out.println("---------");

        AbstractFactory abstractFactory1 = new BmwFactory();
        Car newCar1 = abstractFactory1.getCar();
        Bike newBike3 = abstractFactory1.getBike();
        newCar1.drive();
        newBike3.drive();

    }
}

interface Car {
    void drive();
}

interface Bike {
    void drive();
}

interface Truck {
    void drive();
}

class MercedesCar implements Car {
    public void drive() {
        System.out.println("drive mercedes car");

    }
}

class BmwCar implements Car {
    public void drive() {
        System.out.println("drive bmw car ");
    }
}

class MercedesBike implements Bike {
    public void drive() {
        System.out.println("drive mercedes bike");
    }
}

class BmwBike implements Bike {
    public void drive() {
        System.out.println("drive bmw bike");
    }
}

class MercedesTruck implements Truck {
    public void drive() {
        System.out.println("drive mercedes truck");
    }
}

interface AbstractFactory {
    Car getCar();
    Bike getBike();
    Truck getTruck();
}

class MercedesFactory implements AbstractFactory {

    @Override
    public Car getCar() {
        return new MercedesCar();
    }

    @Override
    public Bike getBike() {
        return new MercedesBike();
    }

    @Override
    public Truck getTruck() {
        return new MercedesTruck();
    }
}


class BmwFactory implements AbstractFactory {

    @Override
    public Car getCar() {
        return new BmwCar();
    }

    @Override
    public Bike getBike() {
        return new BmwBike();
    }

    @Override
    public Truck getTruck() {
        return null;
    }
}

