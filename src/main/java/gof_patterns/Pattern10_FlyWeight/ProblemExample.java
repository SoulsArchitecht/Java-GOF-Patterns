package gof_patterns.Pattern10_FlyWeight;

import java.util.WeakHashMap;

public class ProblemExample {
    public static void main(String[] args) {
        PersonCache cache = new PersonCache();
        Person mike1 = cache.getPerson("Mike");
        Person mike2 = cache.getPerson("Mike");
        System.out.println(mike1.equals(mike2));
    }
}
// But if we have a many fields this is wrong way!
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

class PersonCache {
    private static final WeakHashMap<String, Person> persons = new WeakHashMap<>();

    public Person getPerson(String name) {
        Person person = persons.get(name);
        if (person == null) {
            person = new Person(name);
            persons.put(name, person);
        }
        return person;
    }
}