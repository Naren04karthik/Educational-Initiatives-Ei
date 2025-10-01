public interface DeviceController {
    void pair(Device device);      
    void connect();                
    void sendData(String payload); 
    void disconnect();             
}
