// Manages gates and flight assignments
public class GateManager extends Colleague {

    public GateManager(String name, AirportOperationsCenter mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("[GateManager " + name + "] Updating gates: " + message);
    }
}
