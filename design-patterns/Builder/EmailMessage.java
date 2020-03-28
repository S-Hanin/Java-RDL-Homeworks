package Builder;

import java.util.Arrays;

public class EmailMessage extends AEmailMessage {
    static class Builder{
        private String body = "";
        private String subject = "";

        Builder setBody(String body){
            this.body = body;
            return this;
        }

        Builder setSubject(String subject){
            this.subject = subject;
            return this;
        }

        EmailMessage build(){
            EmailMessage message = new EmailMessage();
            message.subject = this.subject;
            message.body = this.body;
            return message;
        }
    }

    private EmailMessage(){}

    @Override
    public void send() {

    }

    @Override
    public IEmailMessage receive() {
        return null;
    }

    @Override
    public IEmailMessage create(IRecepient sender, IRecepient... recepient) {
        this.sender = sender;
        this.recepients = Arrays.asList(recepient);
        return this;
    }
}
