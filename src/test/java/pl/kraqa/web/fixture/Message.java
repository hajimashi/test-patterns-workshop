package pl.kraqa.web.fixture;

public class Message {
    private String name;
    private String subject;
    private String email;
    private String message;

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public Message(String name, String subject, String email, String message) {
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.message = message;
    }

    public static Message nextWorkshopQuestion() {
        return new MessageBuilder()
                .email("test.email@example.com")
                .name("Marcin")
                .subject("When there will be next workshop?")
                .message("Hi, I'm wondering when we may expect next workshops from KraQA. Best regards, Marcin")
                .build();
    }

    public static Message wrongEmail() {
        return new MessageBuilder()
                .email("test.email+xx@@@@example.com")
                .name("Marcin")
                .subject("When there will be next workshop?")
                .message("Hi, I'm wondering when we may expect next workshops from KraQA. Best regards, Marcin")
                .build();
    }

    public static class MessageBuilder {
        private String name;
        private String subject;
        private String email;
        private String message;

        public MessageBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MessageBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public MessageBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public Message build() {
            return new Message(name, subject, email, message);
        }
    }
}
