public class WiFiController implements DeviceController {
    private final Device device;
    private boolean connected = false;

    public WiFiController(Device device) {
        this.device = device;
        System.out.println(">> WiFi controller ready for " + device.getName());
    }

    @Override
    public void pair(Device device) {
        System.out.println("[WiFi] Performing WPA3 handshake with " + device.getName() + "...");
        System.out.println("[WiFi] Session token: " + SecurityUtils.generateSessionToken());
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println("[WiFi] Connected to " + device.getName() + " over TCP/IP.");
    }

    @Override
    public void sendData(String payload) {
        if (!connected) {
            System.out.println("[WiFi] Cannot send data. Device is not connected.");
            return;
        }
        System.out.println("[WiFi] Sending TLS-wrapped packet: " + SecurityUtils.tlsWrap(payload));
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println("[WiFi] Disconnected from " + device.getName() + ". See you later!");
    }
}
