package gof_patterns.Pattern5_Command;

public class CommandOnMenu {
    public static void main(String[] args) {
        Command1 command1 = new SaveCommand(new Save());
        Command1 command11 = new OpenCommand(new Open());
        Command1 command12 = new PrintCommand(new Print());
        Button1 button1 = new Button1(command1);
        Button1 button11 = new Button1(command11);
        Shortcut shortcut = new Shortcut(command12);

        button11.clickButton();
        button1.clickButton();
        shortcut.clickShortcut();
    }
}

interface Command1 {
    void execute();
}

class Button1 {
    Command1 command1;

    public Button1(Command1 command1) {
        this.command1 = command1;
    }

    public void clickButton() {
        command1.execute();
    }
}

class Shortcut {
    Command1 command1;

    public Shortcut(Command1 command1) {
        this.command1 = command1;
    }

    public void clickShortcut() {
        command1.execute();
    }
}

class Save {
    boolean action = false;
    public void SaveFile() {
        action = true;
        System.out.println("File was saved");
    }
}

class Open {
    boolean action = false;
    public void OpenFile() {
        action = true;
        System.out.println("File was opened");
    }
}

class Print {
    boolean action = false;
    public void PrintFile() {
        action = true;
        System.out.println("File was printed");
    }
}

class SaveCommand implements Command1 {

    Save save;

    public SaveCommand(Save save) {
        this.save = save;
    }

    @Override
    public void execute() {
        save.SaveFile();
    }
}

class OpenCommand implements Command1 {

    Open open;

    public OpenCommand(Open open) {
        this.open = open;
    }

    @Override
    public void execute() {
        open.OpenFile();
    }
}

class PrintCommand implements Command1 {

    Print print;

    public PrintCommand(Print print) {
        this.print = print;
    }


    @Override
    public void execute() {
        print.PrintFile();
    }
}