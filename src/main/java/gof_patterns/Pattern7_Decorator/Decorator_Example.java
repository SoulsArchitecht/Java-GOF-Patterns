package gof_patterns.Pattern7_Decorator;

/**Декоратор — это структурный паттерн проектирования, который позволяет динамически добавлять объектам
 * новую функциональность, оборачивая их в полезные «обёртки».
  */


public class Decorator_Example {
    public static void main(String[] args) {
        Pizza pepperoniCheesePizza = new PepperoniPizza(new CheesePizza(new DoughPizza()));
        System.out.println(pepperoniCheesePizza.makePizza());
        Pizza pepperoniPizza = new PepperoniPizza(new DoughPizza());
        Pizza cheesePepperoniPizza = new CheesePizza(pepperoniPizza); // another case to create

        System.out.println(pepperoniPizza.makePizza());
        System.out.println(cheesePepperoniPizza.makePizza());

        Pizza tomatoCheesePepperoniPizza = new TomatoPizza(cheesePepperoniPizza);
        System.out.println(tomatoCheesePepperoniPizza.makePizza());

    }
}

interface Pizza {
    String makePizza();
}

class DoughPizza implements Pizza {

    @Override
    public String makePizza() {
        return "with";
    }
}

class CheesePizza implements  Pizza {
    Pizza pizza;

    public CheesePizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + " cheese";
    }
}

class PepperoniPizza implements  Pizza {
    Pizza pizza;

    public PepperoniPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public String makePizza() {
        return pizza.makePizza() + " pepperoni";
    }
}

class TomatoPizza implements Pizza {
    Pizza pizza;

    public TomatoPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public String makePizza() {
        return pizza.makePizza() + " tomato";
    }
}