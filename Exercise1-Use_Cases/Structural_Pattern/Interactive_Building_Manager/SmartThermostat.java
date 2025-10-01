// Leaf component representing a smart thermostat
public class SmartThermostat implements BuildingComponent {
    private double temperature = 24.0; // default temperature in °C
    private double energyUsage = 1.5;  // energy usage in kWh
    private String name;

    public SmartThermostat(String name) {
        this.name = name;
    }

    @Override
    public void adjustTemperature(int delta) {
        temperature += delta;
        System.out.println(name + " Thermostat adjusted to " + temperature + "°C");
    }

    @Override
    public void toggleLights(boolean on) {
        // Thermostat has no lights
    }

    @Override
    public double getEnergyUsage() {
        return energyUsage;
    }

    @Override
    public void evacuate() {
        System.out.println(name + " Thermostat shutting down safely during emergency.");
    }

    @Override
    public String getName() {
        return name;
    }
}
