package gof_patterns.Pattern15_Observer;

/** Начиная с JDK 9 считается deprecated (устаревший). Основные предпосылки:
 * - Not Serializable
 * - No Thread Safety
 */

import java.util.Observable;
import java.util.Observer;

public class ObserverByJDKExample {
    public static void main(String[] args) {
        Subject2 subject2 = new Subject2();
        Subscriber3 subscriber3 = new Subscriber3();
        Subscriber4 subscriber4 = new Subscriber4();

        subject2.addObserver(subscriber3);
        subject2.addObserver(subscriber4);

        subject2.setChanged();

        subject2.notifyObservers("hello!");

    }
}

class Subject2 extends Observable {
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}

class Subscriber3 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("s3 " + arg);
    }
}

class Subscriber4 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("s4 " + arg);
    }
}
