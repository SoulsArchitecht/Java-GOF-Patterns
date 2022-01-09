package gof_patterns.Pattern2_Bridge;

/**Паттерн Bridge (мост) позволяет отделить абстракцию от имплементации
 *
 */

public class BridgeTest {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(new Mercedes());
        vehicle.drive();
        Vehicle vehicle1 = new Truck(new Audi());
        vehicle1.drive();
    }
}

abstract class Vehicle {
    Model model;

    public Vehicle(Model model) {
        this.model = model;
    }

    abstract void drive();
}

interface Model {
    void drive(String str);
}

class Car extends Vehicle {
    public Car(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("drive car");
    }
}

class Truck extends  Vehicle {
    public Truck(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("drive truck");
    }
}

class Audi implements Model {

    @Override
    public void drive(String str) {
        System.out.println(str + " audi");
    }
}

class Mercedes implements Model {

    @Override
    public void drive(String str) {
        System.out.println(str + " mercedes");
    }
}


/*// а завтра нам могут понадобиться гоночные автомобили, трактора, автобусы
// или Lamborgini, Ferrari...
// -> у нас начнет код расти в гиперболической прогрессии.
// патерн бридж позволяет решить эту проблему
interface Car {}
interface Truck {}
interface Bike {}

class MercedesCar {}
class MercedesTruck {}

class ToyotaCar {}
class ToyotaTruck {}

class BmwCar {}
class BmwTruck {}*/
