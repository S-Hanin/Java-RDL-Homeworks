package Builder;

import java.util.List;

public abstract class AEmailMessage implements IEmailMessage {
    List<IRecepient> recepients; // получатели
    IRecepient sender; // отправитель
    String body; // текст письма
    String subject; // тема письма
}
