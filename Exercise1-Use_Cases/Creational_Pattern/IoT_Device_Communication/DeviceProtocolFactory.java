public abstract class DeviceProtocolFactory {
    public abstract DeviceController createController(Device device);

    public void prepare(DeviceController controller, Device device) {
        System.out.println(">> Preparing device " + device.getName() + "...");
        controller.pair(device);
        controller.connect();
    }
}
