package gof_patterns.Pattern15_Observer;

/** Наблюдатель (Observer), так же известен как Издатель-Подписчик — это поведенческий паттерн
проектирования, который создаёт механизм подписки, позволяющий одним объектам следить и реагировать
на события, происходящие в других объектах. */

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
    public static void main(String[] args) {
        Subject subject = new Subject();
        //subject.subscribe(new Subscriber1());
        //subject.subscribe(new Subscriber2());
        Subscriber1 subscriber1 = new Subscriber1();
        Subscriber2 subscriber2 = new Subscriber2();
        subject.subscribe(subscriber1);
        subject.subscribe(subscriber2);

        subject.notifySubscribers("hello dudes!");

        subject.unsubscribe(subscriber2);
        subject.notifySubscribers("good buy!");
    }
}

interface MyObservable {
    void callMe(String msg);
}


class Subscriber1 implements MyObservable {
    @Override
    public void callMe(String msg) {
        System.out.println("s1 " + msg);
    }
}

class Subscriber2 implements MyObservable {

    @Override
    public void callMe(String msg) {
        System.out.println("s2 " + msg);
    }
}

class Subject {
    List<MyObservable> list = new ArrayList<>();

    public void subscribe(MyObservable myObservable) {
        list.add(myObservable);
    }

    public void unsubscribe(MyObservable myObservable) {
        list.remove(myObservable);
    }

    public void notifySubscribers(String msg) {
        list.forEach(item -> item.callMe(msg));
    }
}