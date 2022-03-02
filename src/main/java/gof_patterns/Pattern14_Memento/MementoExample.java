package gof_patterns.Pattern14_Memento;

/**Снимок (Memento) — это поведенческий паттерн проектирования, который позволяет сохранять
восстанавливать прошлые состояния объектов, не раскрывая подробностей их реализации. */

import java.util.ArrayList;
import java.util.List;

public class MementoExample {
    public static void main(String[] args) {
        List<Originator.Memento> list = new ArrayList<>();

        Originator originator = new Originator();
        originator.setState("one");
        list.add(originator.saveState());
        originator.setState("two");
        originator.setState("three");
        list.add(originator.saveState());
        originator.setState("four");
        System.out.println(originator.state);

        originator.restoreFromMemento(list.get(0));
        System.out.println(originator.state);

        originator.restoreFromMemento(list.get(1));
        System.out.println(originator.state);

    }
}

class Originator {
    String state;

    public void setState(String state) {
        this.state = state;
    }

    public Originator.Memento saveState() {
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.state;
    }

    static class Memento {
        String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}



