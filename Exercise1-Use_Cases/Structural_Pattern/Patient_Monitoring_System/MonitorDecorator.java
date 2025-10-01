// Abstract Decorator: Wraps a PatientMonitor
public abstract class MonitorDecorator implements PatientMonitor {
    protected PatientMonitor monitor;

    public MonitorDecorator(PatientMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void monitor() {
        monitor.monitor();
    }

    @Override
    public void evaluate() {
        monitor.evaluate();
    }
}
