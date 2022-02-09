package gof_patterns.Pattern7_Decorator;

public class DecoratorNotifierExample {
    public static void main(String[] args) {
        Notifier SMS = new SMSNotifier(new NotifierService());
        System.out.println(SMS.sendNotify());

        Notifier slack = new SlackNotifier(new NotifierService());
        Notifier slackAndFacebook = new FaceBookNotifier(slack);
        System.out.println(slackAndFacebook.sendNotify());
    }
}

interface Notifier {
    public String sendNotify();
}

class NotifierService implements Notifier {

    @Override
    public String sendNotify() {
        return "Notify sent by";
    }
}

class SMSNotifier implements Notifier {
    Notifier notifier;

    public SMSNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public String sendNotify() {
        return notifier.sendNotify() + " SMS";
    }
}

class FaceBookNotifier implements Notifier {
    Notifier notifier;

    public FaceBookNotifier(Notifier notifier) {
        this.notifier = notifier;
    }


    @Override
    public String sendNotify() {
        return notifier.sendNotify() + " Facebook";
    }
}

class SlackNotifier implements Notifier {
    Notifier notifier;

    public SlackNotifier(Notifier notifier) {
        this.notifier = notifier;
    }


    @Override
    public String sendNotify() {
        return notifier.sendNotify() + " Slack";
    }
}
