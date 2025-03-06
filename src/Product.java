import java.util.*;

public class Product {
    private String name;
    private double price;
    private boolean inStock;
    private Map<Customer, Set<NotificationType>> subscribers = new HashMap<>();

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public void addSubscriber(Customer customer, NotificationType... preferences) {
        subscribers.put(customer, new HashSet<>(Arrays.asList(preferences)));
    }

    public void removeSubscriber(Customer customer) {
        subscribers.remove(customer);
    }

    public void notifySubscribers(String message, NotificationType type) {
        subscribers.forEach((customer, preferences) -> {
            if (preferences.contains(type) || preferences.contains(NotificationType.BOTH)) {
                customer.update(message);
            }
        });
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifySubscribers(name + " price changed: " + newPrice, NotificationType.PRICE);
    }

    public void setInStock(boolean available) {
        this.inStock = available;
        String status = available ? "in stock" : "out of stock";
        notifySubscribers(name + " is now " + status, NotificationType.AMOUNT);
    }

    public static void sendAnnouncement(String msg, List<Product> products) {
        products.forEach(
                product -> product.subscribers.keySet().forEach(
                        customer -> customer.update("ANNOUNCEMENT: " + msg)));
    }

    public String getName() {
        return name;
    }
}