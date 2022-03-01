package gof_patterns.Pattern13_Mediator;

/**Посредник (Mediator) — это поведенческий паттерн проектирования, который позволяет
уменьшить связанность множества классов между собой, благодаря перемещению этих связей
в один класс-посредник.

 Позволяет решить проблему  коммуницирования между объектами*/

import java.util.ArrayList;
import java.util.List;

public class MediatorExample {
    public static void main(String[] args) {
        Chat chat = new ChatMediator();
        ColleagueImpl mike = new ColleagueImpl(chat, "Mike");
        chat.addColleague(mike);
        chat.addColleague(new ColleagueImpl(chat, "John"));
        chat.addColleague(new ColleagueImpl(chat, "Mary"));
        chat.addColleague(new ColleagueImpl(chat, "Alex"));
        mike.sendMessage("hello!");
    }

}

interface Chat {
    void sendMessage(String message, Colleague colleague);
    void addColleague(Colleague colleague);
}

class ChatMediator implements Chat {
    List<Colleague> colleaguesList = new ArrayList<>();

    @Override
    public void sendMessage(String message, Colleague me) {
        colleaguesList.forEach(colleague -> {
            if(colleague != me) {
                colleague.printMessage(message);
            }
        });
    }

    @Override
    public void addColleague(Colleague colleague) {
        colleaguesList.add(colleague);
    }
}

abstract class Colleague {
    Chat chat;
    String name;

    public Colleague(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    abstract void sendMessage(String message);
    abstract void printMessage(String message);
}

class ColleagueImpl extends Colleague {

    public ColleagueImpl(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    void printMessage(String message) {
        System.out.println(name + " " + message);
    }
}