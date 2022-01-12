package gof_patterns.Pattern4_ChainOfResponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChainOfResponsibilityHelpDeskExample {
    public static void main(String[] args) {
        try {
            HelpDeskHandler helpDeskHandler = new HelpDeskFirstLink(new HelpDeskSecondLink(new HelpDeskThirdLink(null)));
            helpDeskHandler.handle("Connect to");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

abstract class HelpDeskHandler {
    HelpDeskHandler handler;

    public HelpDeskHandler(HelpDeskHandler handler) {
        this.handler = handler;
    }

    abstract void handle(String message);
}

class HelpDeskFirstLink extends HelpDeskHandler {

    public HelpDeskFirstLink(HelpDeskHandler handler) {
        super(handler);
    }

    @Override
    void handle(String message) {
        System.out.println("Print 1 if you need Robo advice");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (!input.equals("1")) {
                System.out.println("change connecting");
                handler.handle(message);
            } else {
                System.out.println("Do something....by Robo advice");
                System.out.println("Many thanks for your call");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HelpDeskSecondLink extends  HelpDeskHandler {

    public HelpDeskSecondLink(HelpDeskHandler handler) {
        super(handler);
    }

    @Override
    void handle(String message) {
        System.out.println("May Operator can help you? Print 'Y' to listen an advice");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (!input.equals("Y")) {
                System.out.println("change connecting");
                handler.handle(message);
            } else {
                System.out.println("Do something.... by Operator advice");
                System.out.println("Many thanks for your call");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HelpDeskThirdLink extends HelpDeskHandler {

    public HelpDeskThirdLink(HelpDeskHandler handler) {
        super(handler);
    }

    @Override
    void handle(String message)  {
        System.out.println("May Technical Specialist can help you? Print 'Y' to listen an advice");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (!input.equals("Y")) {
                System.out.println("Thanks for you call");
            } else {
                System.out.println("Do something.... by Technical advice");
                System.out.println("Many thanks for your call");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
