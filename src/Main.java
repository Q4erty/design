import decortor.BasicNotification;
import decortor.Notification;
import decortor.impl.EmailNotification;
import decortor.impl.PremiumMessageDecorator;
import decortor.impl.SMSNotification;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product phone = new Product("Samsung Galaxy S24", 500000, true);
        Product laptop = new Product("Asus ROG", 1200000, true);

        Customer aizhan = new Customer("Aizhan");
        Customer nurboll = new Customer("Nurboll");
        Customer yermek = new Customer("Yermek");

        Notification emailNotification = new EmailNotification(new BasicNotification(aizhan.getName()));
        Notification smsNotification = new SMSNotification(new BasicNotification(nurboll.getName()));
        Notification premiumNotification = new PremiumMessageDecorator(new EmailNotification(new BasicNotification(yermek.getName())));

        aizhan.setNotification(emailNotification);
        nurboll.setNotification(smsNotification);
        yermek.setNotification(premiumNotification);

        aizhan.subscribeToProduct(phone, NotificationType.PRICE);
        nurboll.subscribeToProduct(phone, NotificationType.AMOUNT);
        yermek.subscribeToProduct(phone, NotificationType.BOTH);

        BeautifulConsole.printLine();
        phone.setPrice(450000);

        nurboll.unsubscribeFromProduct(phone);
        yermek.unsubscribeFromProduct(phone);
        aizhan.changePreferences(phone, NotificationType.AMOUNT);

        phone.setPrice(400000);

        BeautifulConsole.printLine();
        phone.setInStock(false);
        phone.setInStock(true);

        aizhan.subscribeToProduct(laptop, NotificationType.BOTH);
        nurboll.subscribeToProduct(laptop, NotificationType.PRICE);

        BeautifulConsole.printLine();
        laptop.setPrice(1150000);

        BeautifulConsole.printLine();
        Product.sendAnnouncement("Soon new iPhone 16 in sale", List.of(phone, laptop));
    }
}
