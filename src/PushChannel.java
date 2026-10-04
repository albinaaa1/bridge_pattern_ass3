// Реализация I3 (добавляется на этапе расширения)
public class PushChannel implements Channel {
    @Override
    public String send(String content) {
        return "[Push Envelope] " + content;
    }
}