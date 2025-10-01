// Ground crew handles luggage, refueling, and runway prep
public class GroundCrew extends Colleague {

    public GroundCrew(String name, AirportOperationsCenter mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("[GroundCrew " + name + "] Acting on: " + message);
    }
}
