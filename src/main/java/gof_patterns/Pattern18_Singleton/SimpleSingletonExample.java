package gof_patterns.Pattern18_Singleton;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SimpleSingletonExample {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton.equals(singleton1));
        System.out.println(singleton.getI());

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton.equals(enumSingleton1));

        //1 serialization example:
        try (FileOutputStream fileOutputStream = new FileOutputStream("text.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("text.txt");
             ObjectInputStream in = new ObjectInputStream(fileInputStream)) {

            out.writeObject(enumSingleton);
            enumSingleton = (EnumSingleton) in.readObject();
            System.out.println(enumSingleton.equals(enumSingleton1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2 creating object throw reflection example
        Constructor<Singleton> constructor =
                (Constructor<Singleton>) Singleton.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        Singleton singleton2 = constructor.newInstance();
        System.out.println(singleton2.equals(singleton));

        // exception will throw
/*
        Constructor<EnumSingleton> constructor2 =
                (Constructor<EnumSingleton>) EnumSingleton.class.getDeclaredConstructors()[0];
        constructor2.setAccessible(true);
        EnumSingleton enumSingleton2 = constructor2.newInstance();
        System.out.println(enumSingleton2.equals(enumSingleton));
*/

        //3 creating object throw classLoader
        ClassLoader classLoader = Singleton.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("gof_patterns.Pattern18_Singleton.Singleton");

        Constructor<Singleton> constructor3 =
                (Constructor<Singleton>) loadClass.getDeclaredConstructors()[0];
        constructor3.setAccessible(true);

        Singleton singleton3 = constructor3.newInstance();
        System.out.println(singleton3.equals(singleton));


        ClassLoader classLoader1 = EnumSingleton.class.getClassLoader();
        Class<?> loadClass1 = classLoader1.loadClass("gof_patterns.Pattern18_Singleton.EnumSingleton");
        EnumSingleton enumSingleton2 = (EnumSingleton) loadClass1.getEnumConstants()[0];
        System.out.println(enumSingleton2.equals(enumSingleton));

        //4 creating object throw unsafe
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        Singleton singleton4 = (Singleton) unsafe.allocateInstance(Singleton.class);
        System.out.println(singleton4.equals(singleton));
        // и только в этом случае можно провернуть и с Enum -> false
        EnumSingleton enumSingleton3 = (EnumSingleton) unsafe.allocateInstance(EnumSingleton.class);
        System.out.println(enumSingleton3.equals(enumSingleton));


    }
}

// simple version and bad practice (must have for serialization!)
class Singleton {
    private static Singleton instance;
    private final int i = 5;

    public static Singleton getInstance () {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public int getI() {
        return i;
    }
}

enum EnumSingleton {
    INSTANCE;
    private int i;

    public int getI() {
        return i;
    }
}