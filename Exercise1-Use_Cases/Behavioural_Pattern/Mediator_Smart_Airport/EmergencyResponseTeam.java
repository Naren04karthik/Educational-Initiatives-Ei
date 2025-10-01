// Handles emergencies on runway or in terminal
public class EmergencyResponseTeam extends Colleague {

    public EmergencyResponseTeam(String name, AirportOperationsCenter mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("[EmergencyResponseTeam " + name + "] Responding to: " + message);
    }
}

