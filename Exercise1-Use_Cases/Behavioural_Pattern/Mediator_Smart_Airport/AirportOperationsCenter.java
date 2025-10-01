import java.util.ArrayList;
import java.util.List;

// Mediator coordinating all airport operations
public class AirportOperationsCenter {
    private List<Colleague> colleagues = new ArrayList<>();

    // Register a colleague with the mediator
    public void registerColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    // Notify all colleagues
    public void notifyColleagues(String event, Colleague sender) {
        for (Colleague c : colleagues) {
            if (c != sender) {
                c.receive(event);
            }
        }
    }

    // Handle emergency landing
    public void handleEmergencyLanding(String flightNumber) {
        String alert = "Emergency landing for flight " + flightNumber + "!";
        System.out.println("\n[Mediator] Coordinating emergency landing...");
        for (Colleague c : colleagues) {
            c.receive(alert);
        }
    }

    // Handle weather alert
    public void handleWeatherAlert(String weather) {
        String alert = "Weather alert: " + weather;
        System.out.println("\n[Mediator] Distributing weather alert...");
        for (Colleague c : colleagues) {
            c.receive(alert);
        }
    }

    // Handle flight delay
    public void handleFlightDelay(String flightNumber, String reason) {
        String alert = "Flight " + flightNumber + " delayed due to " + reason;
        System.out.println("\n[Mediator] Informing departments and passengers...");
        for (Colleague c : colleagues) {
            c.receive(alert);
        }
    }
}
