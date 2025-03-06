package decortor.impl;

import decortor.Notification;
import decortor.NotificationDecorator;

public class SMSNotification extends NotificationDecorator {

    public SMSNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("☏: " + message);
    }
}
