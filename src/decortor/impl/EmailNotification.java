package decortor.impl;

import decortor.Notification;
import decortor.NotificationDecorator;

public class EmailNotification extends NotificationDecorator {

    public EmailNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("✉: " + message);
    }
}
