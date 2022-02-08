package gof_patterns.Pattern6_Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Компоновщик — это структурный паттерн проектирования, который позволяет сгруппировать
   множество объектов в древовидную структуру, а затем работать с ней так, как будто это
   единичный объект.

   Паттерн Компоновщик имеет смысл только тогда, когда основная модель вашей программы может быть
   структурирована в виде дерева. */

public class CompositeTestExample {
    public static void main(String[] args) {
        Folder users = new Folder("users");
        Folder etc = new Folder("etc");
        Folder root = new Folder("root");
        root.addFolder(users, etc);

        Folder alex = new Folder("alex");
        Folder ivan = new Folder("ivan");
        Folder john = new Folder("john");
        users.addFolder(alex, ivan, john);

        Folder first = new Folder("one");
        Folder second = new Folder("second");
        Folder third = new Folder("third");

        alex.addFolder(first, second, third);

        root.printFolders();
    }
}

class Folder {
    String name;

    public Folder(String name) {
        this.name = name;
    }

    List<Folder> list = new ArrayList<>();

    public void addFolder(Folder folder) {
        list.add(folder);
    }

    public void addFolder(Folder... folders) {
        list.addAll(Arrays.asList(folders));
    }

    public void printFolders() {
        for(Folder folder : list) {
            System.out.println(folder.name);
            folder.printFolders();
        }
    }
}
