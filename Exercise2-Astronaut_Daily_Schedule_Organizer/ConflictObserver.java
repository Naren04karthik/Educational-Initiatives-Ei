
// ConflictObserver.java
// Concrete implementation of Observer that alerts users when conflicts occur.

public class ConflictObserver implements Observer {
    @Override
    public void notify(String message) {
        // Print notification message to user
        System.out.println("Notification: " + message);
    }
}

