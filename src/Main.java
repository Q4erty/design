import decortor.BasicNotification;
import decortor.Notification;
import decortor.impl.EmailNotification;
import decortor.impl.PremiumMessageDecorator;
import decortor.impl.SMSNotification;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("MacBook", 1999.99, true);
        Customer alice = new Customer("Alice");

        Notification notification = new PremiumMessageDecorator(new EmailNotification(new BasicNotification(alice.getName())));

        alice.setNotification(notification);

        alice.subscribeToProduct(laptop, NotificationType.PRICE);

        BeautifulConsole.printLine();
        laptop.setPrice(1899.99);

        Customer bob = new Customer("Bob");
        bob.setNotification(new SMSNotification(new BasicNotification(bob.getName())));

        bob.subscribeToProduct(laptop, NotificationType.BOTH);

        BeautifulConsole.printLine();
        Product.sendAnnouncement("New products arriving!", List.of(laptop));
    }
}