// Abstract class for composite components (Room, Floor, Wing, Building, Campus)
import java.util.ArrayList;
import java.util.List;

public abstract class CompositeComponent implements BuildingComponent {
    protected String name;                        // Name of this composite
    protected List<BuildingComponent> children;   // List of child components

    public CompositeComponent(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addComponent(BuildingComponent component) {
        children.add(component);
    }

    public void removeComponent(BuildingComponent component) {
        children.remove(component);
    }

    @Override
    public void adjustTemperature(int delta) {
        System.out.println(name + " adjusting temperature by " + delta + "°C");
        for (BuildingComponent c : children) {
            c.adjustTemperature(delta);
        }
    }

    @Override
    public void toggleLights(boolean on) {
        System.out.println(name + " toggling lights: " + (on ? "ON" : "OFF"));
        for (BuildingComponent c : children) {
            c.toggleLights(on);
        }
    }

    @Override
    public double getEnergyUsage() {
        double total = 0;
        for (BuildingComponent c : children) {
            total += c.getEnergyUsage();
        }
        System.out.println(name + " energy usage aggregated: " + total + " kWh");
        return total;
    }

    @Override
    public void evacuate() {
        System.out.println(name + " initiating evacuation procedures...");
        for (BuildingComponent c : children) {
            c.evacuate();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    // Find child component by name
    public BuildingComponent findByName(String target) {
        if (this.name.equalsIgnoreCase(target)) return this;
        for (BuildingComponent c : children) {
            if (c.getName().equalsIgnoreCase(target)) return c;
            if (c instanceof CompositeComponent) {
                BuildingComponent result = ((CompositeComponent) c).findByName(target);
                if (result != null) return result;
            }
        }
        return null;
    }
}
