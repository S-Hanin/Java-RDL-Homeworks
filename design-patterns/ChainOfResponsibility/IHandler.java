package ChainOfResponsibility;

public interface IHandler {
    IHandler setNextHandler(IHandler handler); // следующий обработчик
    void handle(Request request); // обработка запроса
    boolean validate(Request request); // проверяет, можно ли обработать запрос
}
