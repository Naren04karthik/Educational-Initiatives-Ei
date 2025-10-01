public class Device {
    private final String id;
    private final String name;
    private final Protocol protocol;

    public enum Protocol { ZIGBEE, WIFI, BLUETOOTH }

    public Device(String id, String name, Protocol protocol) {
        this.id = id;
        this.name = name;
        this.protocol = protocol;
        System.out.println(">> Device created: " + this);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Protocol getProtocol() { return protocol; }

    @Override
    public String toString() {
        return String.format("Device[id=%s, name=%s, protocol=%s]", id, name, protocol);
    }
}
