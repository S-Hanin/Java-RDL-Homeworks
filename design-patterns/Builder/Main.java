package Builder;

public class Main {
    public static void main(String[] args) {
        EmailMessage.Builder builder = new EmailMessage.Builder();
        EmailMessage message = builder.setSubject("subject")
                .setBody("body").build();

    }
}
