package gof_patterns.Pattern12_Iterator;

/**Итератор (Iterator) — это поведенческий паттерн проектирования,
который даёт возможность последовательно обходить элементы составных объектов,
не раскрывая их внутреннего представления. */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        Menu menu = new Menu();
        MyIterator<String> myIterator = menu.getMyIterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        Menu2 menu2 = new Menu2();
        MyIterator<String> myIterator1 = menu.getMyIterator();
        while (myIterator1.hasNext()) {
            System.out.println(myIterator1.next());
        }

        // нужна имплементация Iterable
        for(String m : new Menu2()) {
            System.out.println(m);
        }

        //или
        new Menu2().forEach(str -> System.out.println(str));

        //или
        new Menu2().forEach(System.out::println);
    }
}

// для array
class Menu implements Iterable<String> {
    String[] items = {"one", "two", "three"};
    MyIterator<String> getMyIterator() {
        return new MyIterator<String>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public String next() {
                return items[index++];
            }
        };
    }
    // или встроенный в Джава итератор
    Iterator<String> getIterator() {
        return Arrays.stream(items).iterator();
    }

    // для Iterable, а он для forEach
    @Override
    public Iterator<String> iterator() {
        return Arrays.stream(items).iterator();
    }
}

// для arrayList
class Menu2 implements Iterable<String> {
    List<String> items = new ArrayList<>();

    public Menu2() {
        items.add("one");
        items.add("two");
        items.add("three");
    }

    MyIterator<String> getMyIterator() {
        return new MyIterator<String>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public String next() {
                return items.get(index++);
            }
        };
    }

    // встроенный в джава
    Iterator<String> getIterator() {
        return items.iterator();
    }

    @Override
    public Iterator<String> iterator() {
        return items.iterator();
    }
}

interface MyIterator<T> {
    boolean hasNext();
    T next();
}