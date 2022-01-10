package gof_patterns.Pattern3_Builder;

class NewCar {
    // Автомобили могут отличаться комплектацией: типом
// двигателя, количеством сидений, могут иметь или не иметь
// GPS и систему навигации и т. д. Кроме того, автомобили
// могут быть городскими, спортивными или внедорожниками.
    int seats;
    String engineType;
    boolean tripComputer;
    boolean GPS;

    @Override
    public String toString() {
        return "NewCar{" +
                "seats=" + seats +
                ", engineType='" + engineType + '\'' +
                ", tripComputer=" + tripComputer +
                ", GPS=" + GPS +
                '}';
    }
}
class NewCarManual {
    // Руководство пользователя для данной конфигурации
// автомобиля.
    int seats;
    String engineType;
    boolean tripComputer;
    boolean GPS;

    @Override
    public String toString() {
        return "Manual{" +
                "seats=" + seats +
                ", engineType=" + engineType +
                ", tripComputer=" + tripComputer +
                ", GPS=" + GPS +
                '}';
    }
}

// Интерфейс строителя объявляет все возможные этапы и шаги
// конфигурации продукта.
interface NewBuilder {
    void reset();

    NewBuilder setSeats(int seats);

    NewBuilder setEngineType(String engine);

    NewBuilder setTripComputer(boolean tripComputer);

    NewBuilder setGPS(boolean GPS);

}
// Все конкретные строители реализуют общий интерфейс по-своему.
class NewCarBuilder implements NewBuilder {
    private NewCar newCar;

    @Override
    public void reset() {
        newCar = new NewCar();
    }

    @Override
    public NewBuilder setSeats(int seats) {
        newCar.seats = seats;
        return this;
    }

    @Override
    public NewBuilder setEngineType(String engineType) {
        newCar.engineType = engineType;
        return this;
    }

    @Override
    public NewBuilder setTripComputer(boolean tripComputer) {
        newCar.tripComputer = tripComputer;
        return this;
    }

    @Override
    public NewBuilder setGPS(boolean GPS) {
        newCar.GPS = GPS;
        return this;
    }

    public NewCar build() {
        return newCar;
    }
}

// В отличие от других порождающих паттернов, где продукты
// должны быть частью одной иерархии классов или следовать
// общему интерфейсу, строители могут создавать совершенно
// разные продукты, которые не имеют общего предка.
class NewCarManualBuilder implements NewBuilder {
    private NewCarManual newCarManual;

    @Override
    public void reset() {
        newCarManual = new NewCarManual();
    }

    @Override
    public NewBuilder setSeats(int seats) {
        newCarManual.seats = seats;
        return this;
    }

    @Override
    public NewBuilder setEngineType(String engineType) {
        newCarManual.engineType = engineType;
        return this;
    }

    @Override
    public NewBuilder setTripComputer(boolean tripComputer) {
        newCarManual.tripComputer = tripComputer;
        return this;
    }

    @Override
    public NewBuilder setGPS(boolean GPS) {
        newCarManual.GPS = GPS;
        return this;
    }

    public NewCarManual build() {
        return newCarManual;
    }
}

// Директор знает, в какой последовательности нужно заставлять
// работать строителя, чтобы получить ту или иную версию
// продукта. Заметьте, что директор работает со строителем через
// общий интерфейс, благодаря чему он не знает тип продукта,
// который изготовляет строитель.
class Director {
    private NewBuilder newBuilder;

    public void constructSportCar(NewBuilder newBuilder) {
        newBuilder.reset();
        newBuilder.setSeats(4);
        newBuilder.setEngineType("SportEngine");
        newBuilder.setTripComputer(true);
        newBuilder.setGPS(false);
    }

}

// Директор получает объект конкретного строителя от клиента
// (приложения). Приложение само знает, какого строителя нужно
// использовать, чтобы получить определённый продукт.
public class BuildCarManualExampleExtended {
    public static void main(String[] args) {

        Director director = new Director();
        NewBuilder newCarBuilder = new NewCarBuilder();
        director.constructSportCar(newCarBuilder);

        NewCar newCar = ((NewCarBuilder) newCarBuilder).build();

        NewCarManualBuilder newCarManualBuilder = new NewCarManualBuilder();
        director.constructSportCar(newCarManualBuilder);

        // Готовый продукт возвращает строитель, так как
        // директор чаще всего не знает и не зависит от
        // конкретных классов строителей и продуктов.
        NewCarManual newCarManual = newCarManualBuilder.build();

        System.out.println(newCar);
        System.out.println(newCarManual);

    }
}
