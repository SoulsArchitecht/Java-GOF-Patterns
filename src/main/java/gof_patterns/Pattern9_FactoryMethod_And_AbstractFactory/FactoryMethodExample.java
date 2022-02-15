package gof_patterns.Pattern9_FactoryMethod_And_AbstractFactory;

/** Фабричный метод (Factory Method) — это порождающий паттерн проектирования, который определяет
 *  общий интерфейс для создания объектов в суперклассе, позволяя подклассам изменять тип
 *  создаваемых объектов. */


public class FactoryMethodExample {
    public static void main(String[] args) {
        CarFactory carFactory = new MercedesFactory();
        carFactory.createCar();
    }
}

interface Car {
    void drive();
}

class Mercedes implements Car {
    public void drive() {
        System.out.println("drive mercedes");
    }
}

class Bmw implements Car {
    public void drive() {
        System.out.println("drive bmw");
    }
}
abstract class CarFactory {
    public void createCar() {
        Car car = getCar();
        car.drive();
        //..more code
    }
    abstract Car getCar();
}

class MercedesFactory extends CarFactory {

    @Override
    Car getCar() {
        return new Mercedes();
    }
}