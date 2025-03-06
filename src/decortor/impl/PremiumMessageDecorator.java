package decortor.impl;

import decortor.Notification;
import decortor.NotificationDecorator;

public class PremiumMessageDecorator extends NotificationDecorator {

    public PremiumMessageDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        String newMessage = "★ " + message + " ★";
        notification.send(newMessage);
    }
}
