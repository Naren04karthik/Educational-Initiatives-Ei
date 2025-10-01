public class WiFiDeviceFactory extends DeviceProtocolFactory {
    @Override
    public DeviceController createController(Device device) {
        System.out.println(">> Creating WiFi controller for " + device.getName());
        return new WiFiController(device);
    }
}
