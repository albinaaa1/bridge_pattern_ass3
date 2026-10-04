// Реализация I2
public class SmsChannel implements Channel {
    @Override
    public String send(String content) {
        return "SMS: " + content;
    }
}