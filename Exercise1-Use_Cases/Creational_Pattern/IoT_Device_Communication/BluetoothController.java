public class BluetoothController implements DeviceController {
    private final Device device;
    private boolean connected = false;

    public BluetoothController(Device device) {
        this.device = device;
        System.out.println(">> Bluetooth controller ready for " + device.getName());
    }

    @Override
    public void pair(Device device) {
        System.out.println("[Bluetooth] BLE pairing for " + device.getName() + "...");
        System.out.println("[Bluetooth] Link key: " + SecurityUtils.generateLinkKey());
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println("[Bluetooth] Connected to " + device.getName() + " via GATT services.");
    }

    @Override
    public void sendData(String payload) {
        if (!connected) {
            System.out.println("[Bluetooth] Cannot send data. Device is not connected.");
            return;
        }
        System.out.println("[Bluetooth] Sending obfuscated GATT data: " + SecurityUtils.simpleObfuscate(payload));
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println("[Bluetooth] Disconnected from " + device.getName() + ". Have a nice day!");
    }
}
