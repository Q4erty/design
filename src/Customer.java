import decortor.BasicNotification;
import decortor.Notification;

import java.util.*;

public class Customer {
    private final String name;
    private Notification notification;
    private final Map<Product, Set<NotificationType>> subs = new HashMap<>();

    public Customer(String name) {
        this.name = name;
        this.notification = new BasicNotification(name);
    }

    public void update(String message) {
        notification.send(message);
    }

    public void subscribeToProduct(Product product, NotificationType... preferences) {
        product.addSubscriber(this, preferences);
        subs.put(product, new HashSet<>(Arrays.asList(preferences)));
    }

    public void unsubscribeFromProduct(Product product) {
        product.removeSubscriber(this);
        subs.remove(product);
    }

    public void changePreferences(Product product, NotificationType... newPreferences) {
        if (subs.containsKey(product)) {
            product.removeSubscriber(this);
            product.addSubscriber(this, newPreferences);
        }
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getName() {
        return name;
    }
}