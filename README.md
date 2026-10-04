# Assignment 3: Bridge Pattern Implementation

* **Student Name:** Onlasyn Albina Adiletqyzy
* **Group:** SE-2527
* **Topic:** Option B — Notifications
* **Repository URL:** https://github.com/albinaaa1/bridge_pattern_ass3

---

## Role Map

| Pattern Role | Entity Name | Source Path | Key Methods / Locations |
| :--- | :--- | :--- | :--- |
| **Abstraction** | `Notification` | `src/Notification.java` | Base class storing `Channel` field, `execute()`, `setImplementation()` |
| **Refined Abstraction A1** | `Reminder` | `src/Reminder.java` | Extends `Notification`, formats reminder message |
| **Refined Abstraction A2** | `UrgentAlert` | `src/UrgentAlert.java` | Extends `Notification`, formats urgent message |
| **Implementor** | `Channel` | `src/Channel.java` | Interface defining `send(String content)` |
| **Concrete Implementor I1**| `EmailChannel` | `src/EmailChannel.java` | Implements `send()` with email envelope |
| **Concrete Implementor I2**| `SmsChannel` | `src/SmsChannel.java` | Implements `send()` with SMS prefix |
| **Concrete Implementor I3**| `PushChannel` | `src/PushChannel.java` | Extension class implementing `send()` with push envelope |
| **Client** | `Main` | `src/Main.java` | Standard entry point executing T1–T7 checks |

---

## Key Method Locations

* **Bridge Field:** `protected Channel channel;` in `src/Notification.java`
* **Execute Method:** `execute()` in `src/Notification.java` (implemented in `Reminder.java` and `UrgentAlert.java`)
* **Set Implementation:** `setImplementation(Channel channel)` in `src/Notification.java`
* **Runtime Switch Check:** Demonstrated in test `T5` within `src/Main.java`

---

## Build & Run Commands

From the project root folder:

```bash
javac -release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main
