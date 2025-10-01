// Monitors weather conditions
public class WeatherStation extends Colleague {

    public WeatherStation(String name, AirportOperationsCenter mediator) {
        super(name, mediator);
    }

    public void reportWeather(String condition) {
        System.out.println(name + " reports weather: " + condition);
        mediator.handleWeatherAlert(condition);
    }

    @Override
    public void receive(String message) {
        System.out.println("[WeatherStation " + name + "] Alert received: " + message);
    }
}
