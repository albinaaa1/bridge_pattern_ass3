// Реализация I1
public class EmailChannel implements Channel {
    @Override
    public String send(String content) {
        return "[Email Envelope] " + content;
    }
}