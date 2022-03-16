package gof_patterns.Pattern19_State;

/**
 * Состояние (State) — это поведенческий паттерн проектирования, который позволяет объектам менять
 * поведение в зависимости от своего состояния. Извне создаётся впечатление, что изменился класс объекта.
 */

import java.util.Random;

public class StateExample {
    public static void main(String[] args) {
        GumMachine gumMachine = new GumMachine();
        gumMachine.turnCrank();
        gumMachine.insertQuarter();
        gumMachine.insertQuarter();
        gumMachine.turnCrank();
    }
}
//best practice example (by pattern):

abstract class State {
    int count = 10;

    abstract public void insertQuarter(GumMachine gumMachine);

    abstract public void turnCrank(GumMachine gumMachine);
}

class GumMachine {
    State state = new NoQuarter();

    public void insertQuarter() {
        state.insertQuarter(this);
    }

    public void turnCrank() {
        state.turnCrank(this);
    }
}

class SoldOut extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        System.out.println("no gums anymore");
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("no gums anymore");
    }
}

class HasQuarter extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        System.out.println("you've already drop quarter");
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        if (count <= 0) {
            gumMachine.state = new SoldOut();
        } else {
            System.out.println("selling...");
            count--;
            gumMachine.state = new NoQuarter();
        }

    }
}

class NoQuarter extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        if (new Random().nextBoolean()) {
            System.out.println("you're winner!");
            gumMachine.state = new Winner();
        } else {
            gumMachine.state = new HasQuarter();
        }
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("no quarter");
    }
}

class Winner extends State {

    @Override
    public void insertQuarter(GumMachine gumMachine) {
        System.out.println("you're winner");
    }

    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("get the gum");
        gumMachine.state = new NoQuarter();
        count--;
    }
}

//bad practice example:

/*
enum GumMachineState {
    SOLD_OUT, NO_QUARTER, HAS_QUARTER, WINNER
}

class GunMachine {
    int count = 10;
    GumMachineState state = GumMachineState.NO_QUARTER;

    public void insertQuarter() {
        if (state.equals(GumMachineState.HAS_QUARTER)) {
            System.out.println("you can't insert another");
        } else if (state.equals(GumMachineState.NO_QUARTER)) {
            state = GumMachineState.HAS_QUARTER;
        } else if (state.equals(GumMachineState.SOLD_OUT)) {
            System.out.println("no gums anymore");
        } else if (state.equals(GumMachineState.WINNER)) {
            System.out.println("you are winner");
        }
    }

    public void turnCrank() {
        if (state.equals(GumMachineState.HAS_QUARTER)) {
            if (count <= 0) {
                state = GumMachineState.SOLD_OUT;
            } else {
                System.out.println("selling...");
                state = GumMachineState.NO_QUARTER;
                count--;
            }
        } else if (state.equals(GumMachineState.NO_QUARTER)) {
            System.out.println("you didn't insert quarter");
        } else if (state.equals(GumMachineState.WINNER)) {
            System.out.println("give a gum");
            state = GumMachineState.NO_QUARTER;
            count--;
        }
    }
}
*/
