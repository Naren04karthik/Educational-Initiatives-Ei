// Notifies passengers about delays, gate changes, emergencies
public class PassengerNotifier extends Colleague {

    public PassengerNotifier(String name, AirportOperationsCenter mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("[PassengerNotifier] Informing passengers: " + message);
    }
}
