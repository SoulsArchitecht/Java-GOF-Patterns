package gof_patterns.Pattern18_Singleton;

/** Одиночка (Singleton) — это порождающий паттерн проектирования, который гарантирует, что у класса есть только один
экземпляр, и предоставляет к нему глобальную точку доступа. */

import java.io.Serializable;

public class ConcurrencySingletonExample {
    public static void main(String[] args) throws InterruptedException {
        ConcurrencySingletonWrapper concurrencySingletonWrapper = new ConcurrencySingletonWrapper();
        ConcurrencySingletonWrapper concurrencySingletonWrapper1 = new ConcurrencySingletonWrapper();


        Thread thread = new Thread(() -> {
            concurrencySingletonWrapper.concurrencySingleton = ConcurrencySingleton.getInstance();
            concurrencySingletonWrapper.concurrencyEnumSingleton = ConcurrencyEnumSingleton.INSTANCE;
        });

        Thread thread1 = new Thread(() -> {
            concurrencySingletonWrapper1.concurrencySingleton = ConcurrencySingleton.getInstance();
            concurrencySingletonWrapper1.concurrencyEnumSingleton = ConcurrencyEnumSingleton.INSTANCE;
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println(concurrencySingletonWrapper.concurrencySingleton.equals(
                concurrencySingletonWrapper1.concurrencySingleton));
        System.out.println(concurrencySingletonWrapper.concurrencyEnumSingleton.equals(
                concurrencySingletonWrapper1.concurrencyEnumSingleton));
    }
}

class ConcurrencySingleton implements Serializable {
    private volatile static ConcurrencySingleton instance;

    public static ConcurrencySingleton getInstance() {
        if (instance == null) {
            synchronized (ConcurrencySingleton.class) {
                if (instance == null) {
                    instance = new ConcurrencySingleton();
                }
            }
        }
        return instance;
    }
}

enum ConcurrencyEnumSingleton implements Serializable {
    INSTANCE;
}

class ConcurrencySingletonWrapper {
    ConcurrencySingleton concurrencySingleton;
    ConcurrencyEnumSingleton concurrencyEnumSingleton;
}
