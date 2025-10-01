public class ZigbeeController implements DeviceController {
    private final Device device;
    private boolean connected = false;

    public ZigbeeController(Device device) {
        this.device = device;
        System.out.println(">> Zigbee controller ready for " + device.getName());
    }

    @Override
    public void pair(Device device) {
        System.out.println("[Zigbee] Pairing device " + device.getName() + " with AES-128 encryption...");
        System.out.println("[Zigbee] Key: " + SecurityUtils.generateAes128Key());
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println("[Zigbee] Successfully connected to " + device.getName() + " via mesh network.");
    }

    @Override
    public void sendData(String payload) {
        if (!connected) {
            System.out.println("[Zigbee] Cannot send data. Device is not connected.");
            return;
        }
        System.out.println("[Zigbee] Sending encrypted data: " + SecurityUtils.aes128Encrypt(payload));
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println("[Zigbee] Disconnected from " + device.getName() + ". Goodbye!");
    }
}
