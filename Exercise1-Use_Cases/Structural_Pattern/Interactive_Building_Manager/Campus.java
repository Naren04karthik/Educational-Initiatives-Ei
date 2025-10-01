// Composite representing a Campus
public class Campus extends CompositeComponent {
    public Campus(String name) {
        super("Campus " + name);
    }

    public void setEnergySavingMode() {
        System.out.println(name + " entering Energy-Saving Mode...");
        adjustTemperature(-2);
        toggleLights(true);
    }
}
