package edu.mum.cs.cs525.project.bank.observer;

public class ObserverFactory {

    private static final Observer LOGGER  = new Logger();

    private static final Observer SMS_SENDER  = new SMSSender();

    private static final Observer EMAIL_SENDER  = new EmailSender();

    public static Observer getLOGGER() {
        return LOGGER;
    }

    public static Observer getSmsSender() {
        return SMS_SENDER;
    }

    public static Observer getEmailSender() {
        return EMAIL_SENDER;
    }
}
