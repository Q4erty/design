package decortor;

public class BasicNotification implements Notification {
    private final String name;

    public BasicNotification(String name) {
        this.name = name;
    }

    @Override
    public void send(String message) {
        System.out.println("Basic: " + name + ": " + message);
    }
}
