package gof_patterns.Pattern8_Facade;

/** Фасад (Facade) — это структурный паттерн проектирования, который предоставляет простой интерфейс
к сложной системе классов, библиотеке или фреймворку.
 */


public class FacadeExampleSmartHouse {
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();
        livingRoom.pressButton("8", "22");

        DinningRoom dinningRoom = new DinningRoom();
        dinningRoom.pressButton("5", "20");

    }
}

class Tv {
    void playChannel (String channel) {
        System.out.println("play channel " + channel);
    }
}

class AirConditioning {
    void setTemperature(String temperature) {
        System.out.println("set temperature " + temperature);
    }
}

class Light {
    void turnLight (){
        System.out.println("run light");
    }
}

class RoomFacade {
    Tv tv = new Tv();
    AirConditioning airConditioning = new AirConditioning();
    Light light = new Light();

    public void pressButton(String channel, String temperature) {
        tv.playChannel(channel);
        airConditioning.setTemperature(temperature);
        light.turnLight();
    }
}

class LivingRoom {
    RoomFacade roomFacade = new RoomFacade();
    void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature);
    }
}

class BedRoom {
    RoomFacade roomFacade = new RoomFacade();
    void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature);
    }
}

class DinningRoom {
    RoomFacade roomFacade = new RoomFacade();
    void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature);
    }
}