import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Notification{
       protected String recipient;
       protected String message;
       protected String timestamp;

       public Notification(String recipient,String message){
             this.recipient = recipient;
             this.message = message;
             this.timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
       }

       public String formatHeader() {
        return "[" + timestamp + "] To: " + recipient;
    }

    public void send() {
        System.out.println(formatHeader());
        System.out.println("Message: " + message);
    }

};

class EmailNotification extends Notification{
      private String subject;

        public EmailNotification(String recipient,String message, String subject ) {
             super(recipient, message);
             this.subject = subject;  
        }

        @Override 
        public void send(){
             System.out.println(formatHeader());
           System.out.println("Subject: " + subject);
            System.out.println("Body: " + message);
            System.out.println("Status: Email delivered"); 
        }

};
class SMSNotification extends Notification {
    private String phoneNumber;
    private static final int MAX_LENGTH = 160;

    public SMSNotification(String recipient, String message, String phoneNumber) {
        super(recipient, message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println(formatHeader());
        System.out.println("Phone: " + phoneNumber);
        String smsBody = message.length() > MAX_LENGTH
            ? message.substring(0, MAX_LENGTH - 3) + "..."
            : message;
        System.out.println("SMS: " + smsBody);
        System.out.println("Status: SMS sent (" + smsBody.length() + "/" + MAX_LENGTH + " chars)");
    }
}

class PushNotification extends Notification {
    private String deviceToken;
    private String priority;

    public PushNotification(String recipient, String message,
                            String deviceToken, String priority) {
        super(recipient, message);
        this.deviceToken = deviceToken;
        this.priority = priority;
    }

    @Override
    public void send() {
        System.out.println(formatHeader());
        System.out.println("Device: " + deviceToken.substring(0, 8) + "...");
        System.out.println("Priority: " + priority);
        System.out.println("Alert: " + message);
        System.out.println("Status: Push notification delivered");
    }
}

public class inheritance_poly_runTime {
      public static void main(String[] args) {
        EmailNotification email = new EmailNotification(
            "alice@example.com", "Your order has been shipped!", "Order Update");
        email.send();

        System.out.println();

        SMSNotification sms = new SMSNotification(
            "Bob", "Your verification code is 482910.", "+1-555-0123");
        sms.send();

        System.out.println();

        PushNotification push = new PushNotification(
            "Charlie", "New message from Alice",
            "d8a3f4b2c1e5a9b7", "high");
        push.send();
    }
}
