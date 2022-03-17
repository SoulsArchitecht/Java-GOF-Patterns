package gof_patterns.Pattern20_Strategy;

/**
 * Стратегия (Strategy) — это поведенческий паттерн проектирования, который определяет семейство схожих
 * алгоритмов и помещает каждый из них в собственный класс, после чего алгоритмы можно взаимозаменять прямо
 * во время исполнения программы.
 */


public class StrategyExample {
    public static void main(String[] args) {
        Car car = new Toyota(new FlyCar());
        Car car2 = new Tractor(new NoFlyVehicle());
        car.drive();
        car2.drive();
        car.fly();
        car2.fly();
    }
}

interface Flyable {
    void fly();
}

class FlyCar implements Flyable {

    @Override
    public void fly() {
        System.out.println("can fly");
    }
}

class NoFlyVehicle implements Flyable {

    @Override
    public void fly() {
        System.out.println("can't fly");
    }
}

abstract class Car {
    Flyable flyable;

    public Car(Flyable flyable) {
        this.flyable = flyable;
    }

    abstract void drive();

    public void stop() {
        System.out.println("stop");
    }

    public void fly() {
        flyable.fly();
    }
}

class Toyota extends Car {

    public Toyota(Flyable flyable) {
        super(flyable);
    }

    @Override
    void drive() {
        System.out.println("drive Toyota");
    }
}

class Ferrari extends Car {

    public Ferrari(Flyable flyable) {
        super(flyable);
    }

    @Override
    void drive() {
        System.out.println("drive Ferrari");
    }
}

class Tractor extends Car {

    public Tractor(Flyable flyable) {
        super(flyable);
    }

    @Override
    void drive() {
        System.out.println("drive Tractor");
    }
}

