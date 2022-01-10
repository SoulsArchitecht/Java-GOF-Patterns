package gof_patterns.Pattern3_Builder;

public class BuilderCarManualExample {
    public static void main(String[] args) {
        CarManual manual1 = new CarManualBuilder().setEnginePower(2000).setSeats(5).setGPS(true).build();
        CarManual manual2 = new CarManualBuilder().setEnginePower(1500).setSeats(4).setTripComputer(true).build();
        System.out.println(manual1);
        System.out.println(manual2);
    }
}

class Car {
// Автомобили могут отличаться комплектацией: типом
// двигателя, количеством сидений, могут иметь или не иметь
// GPS и систему навигации и т. д. Кроме того, автомобили
// могут быть городскими, спортивными или внедорожниками.
    private int seats;
    private int EnginePower;
    private boolean tripComputer;
    private boolean GPS;


}
class CarManual {
// Руководство пользователя для данной конфигурации
// автомобиля.
    int seats;
    int enginePower;
    boolean tripComputer;
    boolean GPS;

    @Override
    public String toString() {
        return "Manual{" +
                "seats=" + seats +
                ", enginePower=" + enginePower +
                ", tripComputer=" + tripComputer +
                ", GPS=" + GPS +
                '}';
    }
}

// Интерфейс строителя объявляет все возможные этапы и шаги
// конфигурации продукта.
interface CarBuilder {
    //method reset()

    CarBuilder setSeats(int seats);

    CarBuilder setEnginePower(int enginePower);

    CarBuilder setTripComputer(boolean tripComputer);

    CarBuilder setGPS(boolean GPS);

    CarManual build();
}

class CarManualBuilder implements CarBuilder {
    CarManual manual = new CarManual();

    @Override
    public CarBuilder setSeats(int seats) {
        manual.seats = seats;
        return this;
    }

    @Override
    public CarBuilder setEnginePower(int enginePower) {
        manual.enginePower = enginePower;
        return this;
    }

    @Override
    public CarBuilder setTripComputer(boolean tripComputer) {
        manual.tripComputer = tripComputer;
        return this;
    }

    @Override
    public CarBuilder setGPS(boolean GPS) {
        manual.GPS = GPS;
        return this;
    }

    @Override
    public CarManual build() {
        return manual;
    }
}