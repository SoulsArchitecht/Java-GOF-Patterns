package gof_patterns.Pattern5_Command;

/** Command (Команда) — это поведенческий паттерн проектирования, который превращает запросы в объекты,
позволяя передавать их как аргументы при вызове методов, ставить запросы в очередь, логировать их,
 а также поддерживать отмену операций. */

public class CommandTestExample {
    public static void main(String[] args) {
        Command command = new LightCommand(new Light());
        Command command1 = new MusicPlayerCommand(new MusicPlayer());
        Command command2 = new TVCommand(new TV());
        Command command3 = new CoffeeMachineCommand(new CoffeeMachine(), "Cappuccino");

        Command fireUpAll = new SwitchLightMusicTVAndMakeCoffee(
                new Light(), new MusicPlayer(), new TV(), new CoffeeMachine(), "Latte");

        Button button = new Button(command);
        Button button1 = new Button(command1);
        Button button2 = new Button(command2);
        Button button3 = new Button(command3);

        button.pressButton();
        button1.pressButton();
        button2.pressButton();
        button3.pressButton();
        System.out.println("-----------------------");
        Button buttonForAll = new Button(fireUpAll);
        buttonForAll.pressButton();

    }
}

class Button {
    Command command;

    public Button(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

interface Command {
    void execute();
}

class Light {
    boolean isOn;
    public void switchLight() {
        this.isOn = !this.isOn;
        System.out.println("Light is " + (isOn ? "on" : "off"));
    }
}

class MusicPlayer {
    boolean isOn;
    public void playMusic() {
        this.isOn = !this.isOn;
        System.out.println("Music is " + (isOn ? "on" : "off"));
    }
}

class TV {
    boolean isOn;
    public void switchTV() {
        this.isOn = !this.isOn;
        System.out.println("TV is " + (isOn ? "on" : "off"));
    }
}

class CoffeeMachine {
    void makeCoffee(String type) {
        System.out.println("Making coffee " + type);
    }
}

class LightCommand implements Command {
    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLight();
    }
}

class MusicPlayerCommand implements Command {
    MusicPlayer musicPlayer;

    public MusicPlayerCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.playMusic();
    }
}

class TVCommand implements Command {
    TV tv;

    public TVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.switchTV();
    }
}

class CoffeeMachineCommand implements Command {
    CoffeeMachine coffeeMachine;
    String type;

    public CoffeeMachineCommand(CoffeeMachine coffeeMachine, String type) {
        this.coffeeMachine = coffeeMachine;
        this.type = type;
    }

    @Override
    public void execute() {
        coffeeMachine.makeCoffee(type);
    }
}

class SwitchLightMusicTVAndMakeCoffee implements Command {
    Light light;
    MusicPlayer musicPlayer;
    TV tv;
    CoffeeMachine coffeeMachine;
    String typeOfCoffee;
    //String type = "Latte";

    public SwitchLightMusicTVAndMakeCoffee(
            Light light, MusicPlayer musicPlayer, TV tv, CoffeeMachine coffeeMachine, String typeOfCoffee) {
        this.light = light;
        this.musicPlayer = musicPlayer;
        this.tv = tv;
        this.coffeeMachine = coffeeMachine;
        this.typeOfCoffee = typeOfCoffee;
    }

    @Override
    public void execute() {
        light.switchLight();
        musicPlayer.playMusic();
        tv.switchTV();
        coffeeMachine.makeCoffee(typeOfCoffee);
    }
}