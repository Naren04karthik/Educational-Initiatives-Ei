public class Hub {
    public DeviceProtocolFactory selectFactory(Device.Protocol protocol) {
        System.out.println(">> Selecting factory for protocol: " + protocol);
        switch (protocol) {
            case ZIGBEE: return new ZigbeeDeviceFactory();
            case WIFI: return new WiFiDeviceFactory();
            case BLUETOOTH: default: return new BluetoothDeviceFactory();
        }
    }

    public void connectAndSend(Device device, String data) {
        System.out.println(">> Hub is starting communication with " + device.getName());
        DeviceProtocolFactory factory = selectFactory(device.getProtocol());
        DeviceController controller = factory.createController(device);
        factory.prepare(controller, device);
        controller.sendData(data);
        controller.disconnect();
    }
}
