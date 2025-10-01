public class ZigbeeDeviceFactory extends DeviceProtocolFactory {
    @Override
    public DeviceController createController(Device device) {
        System.out.println(">> Creating Zigbee controller for " + device.getName());
        return new ZigbeeController(device);
    }
}
