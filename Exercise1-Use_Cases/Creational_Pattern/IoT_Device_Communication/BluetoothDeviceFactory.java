public class BluetoothDeviceFactory extends DeviceProtocolFactory {
    @Override
    public DeviceController createController(Device device) {
        System.out.println(">> Creating Bluetooth controller for " + device.getName());
        return new BluetoothController(device);
    }
}
