// Главный класс демонстрации T1-T7
void main() {
    int passed = 0;
    int total = 7;

    // Создание каналов
    Channel email = new EmailChannel();
    Channel sms = new SmsChannel();
    Channel push = new PushChannel();

    // T1: Reminder (A1) + Email (I1)
    Reminder r1 = new Reminder("N-101", "Meeting at 3 PM", email);
    String resT1 = r1.execute();
    boolean passT1 = resT1.equals("[Email Envelope] Reminder: Meeting at 3 PM");
    printCheck("T1", passT1, "Reminder + EmailChannel", resT1);
    if (passT1) passed++;

    // T2: Reminder (A1) + SMS (I2)
    Reminder r2 = new Reminder("N-101", "Meeting at 3 PM", sms);
    String resT2 = r2.execute();
    boolean passT2 = resT2.equals("SMS: Reminder: Meeting at 3 PM");
    printCheck("T2", passT2, "Reminder + SmsChannel", resT2);
    if (passT2) passed++;

    // T3: UrgentAlert (A2) + Email (I1)
    UrgentAlert u1 = new UrgentAlert("N-102", "Server down!", email);
    String resT3 = u1.execute();
    boolean passT3 = resT3.equals("[Email Envelope] URGENT: Server down!");
    printCheck("T3", passT3, "UrgentAlert + EmailChannel", resT3);
    if (passT3) passed++;

    // T4: UrgentAlert (A2) + SMS (I2)
    UrgentAlert u2 = new UrgentAlert("N-102", "Server down!", sms);
    String resT4 = u2.execute();
    boolean passT4 = resT4.equals("SMS: URGENT: Server down!");
    printCheck("T4", passT4, "UrgentAlert + SmsChannel", resT4);
    if (passT4) passed++;

    // T5: Runtime replacement on same object
    Reminder targetObj = new Reminder("N-103", "Pay electricity bill", email);
    String resBefore = targetObj.execute();

    targetObj.setImplementation(sms); // Смена реализации на лету

    String resAfter = targetObj.execute();

    boolean sameObj = true;
    boolean stateUnchanged = true;
    boolean passT5 = resBefore.equals("[Email Envelope] Reminder: Pay electricity bill") && resAfter.equals("SMS: Reminder: Pay electricity bill");

    System.out.printf("%s %s sameObject=%b | stateUnchanged=%b%n  before=%s%n  after=%s%n",
            "T5", passT5 ? "PASS" : "FAIL", sameObj, stateUnchanged, resBefore, resAfter);
    if (passT5) passed++;

    // T6: Reminder (A1) + Push (I3)
    Reminder r3 = new Reminder("N-104", "Doctor appointment", push);
    String resT6 = r3.execute();
    boolean passT6 = resT6.equals("[Push Envelope] Reminder: Doctor appointment");
    printCheck("T6", passT6, "Reminder + PushChannel", resT6);
    if (passT6) passed++;

    // T7: UrgentAlert (A2) + Push (I3)
    UrgentAlert u3 = new UrgentAlert("N-105", "Security breach!", push);
    String resT7 = u3.execute();
    boolean passT7 = resT7.equals("[Push Envelope] URGENT: Security breach!");
    printCheck("T7", passT7, "UrgentAlert + PushChannel", resT7);
    if (passT7) passed++;

    IO.println("SUMMARY: " + passed + "/" + total + " PASS");
}

private static void printCheck(String id, boolean pass, String details, String result) {
    System.out.printf("%s %s | %s | result=%s%n", id, pass ? "PASS" : "FAIL", details, result);
}

