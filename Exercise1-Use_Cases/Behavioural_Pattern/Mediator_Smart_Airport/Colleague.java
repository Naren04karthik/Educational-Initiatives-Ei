// Abstract class representing a participant in airport operations
public abstract class Colleague {
    protected AirportOperationsCenter mediator;
    protected String name;

    public Colleague(String name, AirportOperationsCenter mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    // Receive notifications from mediator
    public abstract void receive(String message);
}
