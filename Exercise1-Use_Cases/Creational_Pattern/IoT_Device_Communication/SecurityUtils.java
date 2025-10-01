import java.util.Base64;
import java.util.UUID;

public class SecurityUtils {
    public static String generateAes128Key() {
        String key = UUID.randomUUID().toString().substring(0, 16);
        System.out.println(">> Generated AES-128 key: " + key);
        return key;
    }

    public static String aes128Encrypt(String data) {
        return "AES128{" + Base64.getEncoder().encodeToString(data.getBytes()) + "}";
    }

    public static String generateSessionToken() {
        String token = UUID.randomUUID().toString();
        System.out.println(">> Generated session token: " + token);
        return token;
    }

    public static String tlsWrap(String data) {
        return "TLS{" + Base64.getEncoder().encodeToString(data.getBytes()) + "}";
    }

    public static String generateLinkKey() {
        String key = UUID.randomUUID().toString().substring(0, 12);
        System.out.println(">> Generated Bluetooth link key: " + key);
        return key;
    }

    public static String simpleObfuscate(String data) {
        return new StringBuilder(data).reverse().toString();
    }
}
