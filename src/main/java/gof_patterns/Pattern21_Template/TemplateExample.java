package gof_patterns.Pattern21_Template;

/**
 * Шаблонный метод (Template Method) — это поведенческий паттерн проектирования, который определяет
 * скелет алгоритма, перекладывая ответственность за некоторые его шаги на подклассы. Паттерн позволяет
 * подклассам переопределять шаги алгоритма, не меняя его общей структуры.
 */


public class TemplateExample {
    public static void main(String[] args) {
        Beverage beverage = new Coffee();
        beverage.makeBeverage();

        Beverage beverage1 = new Tea();
        beverage1.makeBeverage();
    }
}

abstract class Beverage {
    private void boilWater() {
        System.out.println("boil water");
    }

    private void addSugar() {
        System.out.println("add sugar");
    }

    abstract void addBeverage();

    abstract void addCondiment();

    public void makeBeverage() {
        boilWater();
        addBeverage();
        addSugar();
        addCondiment();
        hook();
    }

    void hook() {
    }
}

class Coffee extends Beverage {

    @Override
    void addBeverage() {
        System.out.println("add some coffee");
    }

    @Override
    void addCondiment() {
        System.out.println("add some milk");
    }

    // благодаря hook возможно добавить хоть что на выбор

    @Override
    void hook() {
        System.out.println("add syrup");
    }
}

class Tea extends Beverage {

    @Override
    void addBeverage() {
        System.out.println("add some tea");
    }

    @Override
    void addCondiment() {
        System.out.println("add lemon");
    }
}