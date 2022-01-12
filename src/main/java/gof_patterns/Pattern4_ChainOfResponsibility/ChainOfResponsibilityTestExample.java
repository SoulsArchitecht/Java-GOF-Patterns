package gof_patterns.Pattern4_ChainOfResponsibility;

/** Chain of responsibility - Вертикаль власти (цепочка ответственности, цепочка обязанностей)
 * Цепочка обязанностей — это поведенческий паттерн проектирования, который позволяет
 * передавать запросы последовательно по цепочке обработчиков.
 * Каждый последующий обработчик решает,
 * может ли он обработать запрос сам и стоит ли передавать запрос дальше по цепи.
 *
 *
 * У нас есть два класса, которые коммуницируют: один класс посылает сообщения,
 * другой - их печатает.
 * Но, при усложнениее логики работы методов классов с кодом становится
 * сложно работать. В итого можно создать несколько  принимающих и печатающих классов
 * с разным функционалом. Каждый из них, будет фильтровать и обрабатывать определенным образом.
 * Но так делать неправильно.
 * Правильно сделать абстрактный класс и создать его несколько имплементаций,
 * каждая из которых будет отвечать за свой аспект.
 */

public class ChainOfResponsibilityTestExample {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageAddExclamationMarkHandler(
                new MessageVerifyHandler(new MessagePrintHandler(null)));
        messageHandler.handle("hello world");
    }
}

abstract class MessageHandler {
    MessageHandler messageHandler;

    public MessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    abstract void handle(String message);
}

class MessagePrintHandler extends MessageHandler {
    public MessagePrintHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String message) {
        System.out.println(message);
    }
}

class MessageVerifyHandler extends MessageHandler {

    public MessageVerifyHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String message) {
        if(!message.matches(".*\\d.*")) {
            messageHandler.handle(message);
        } else {
            System.out.println("Error! Your message contains numbers");
        }
    }
}

class MessageAddExclamationMarkHandler extends MessageHandler {

    public MessageAddExclamationMarkHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String message) {
        messageHandler.handle(message + "!");
    }
}

/*
//anti-pattern:
public class ChainOfResponsibilityTestExample {
    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender(new MessagePrinter());
        messageSender.sendMessage("Hello world");
    }
}

class MessageSender {
    MessagePrinter messagePrinter;

    public MessageSender(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void sendMessage(String message) {
        messagePrinter.printMessage(message);
    }
}

class MessagePrinter {
    public void printMessage(String message) {
        if(!message.matches(".*\\d.*")) {
            System.out.println(message);
        }
    }
}

class MessagePrinter2 {
    public void printMessage(String message) {
        System.out.println(message + "!");
    }
}*/
