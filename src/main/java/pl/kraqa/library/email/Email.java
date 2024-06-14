package pl.kraqa.library.email;

public class Email {
    private String subject;
    private String message;
    private String to;

    protected Email(String subject, String message, String to) {
        this.subject = subject;
        this.message = message;
        this.to = to;
    }

    public static class Builder {
        private String subject;
        private String message;
        private String string;

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setTo(String string) {
            this.string = string;
            return this;
        }

        public Email createEmail() {
            return new Email(subject, message, string);
        }
    }
}
