// Air Traffic Control department
public class AirTrafficControl extends Colleague {

    public AirTrafficControl(String name, AirportOperationsCenter mediator) {
        super(name, mediator);
    }

    public void requestEmergencyLanding(String flightNumber) {
        System.out.println(name + " requests emergency landing for flight " + flightNumber);
        mediator.handleEmergencyLanding(flightNumber);
    }

    public void reportFlightDelay(String flightNumber, String reason) {
        System.out.println(name + " reports delay for flight " + flightNumber);
        mediator.handleFlightDelay(flightNumber, reason);
    }

    @Override
    public void receive(String message) {
        System.out.println("[AirTrafficControl " + name + "] Received: " + message);
    }
}
