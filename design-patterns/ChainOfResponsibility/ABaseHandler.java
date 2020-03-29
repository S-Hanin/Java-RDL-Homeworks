package ChainOfResponsibility;

import java.util.Optional;

public abstract class ABaseHandler implements IHandler {
    IHandler next;

    @Override
    public IHandler setNextHandler(IHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(Request request){
        Optional.ofNullable(next).ifPresent(x -> x.handle(request));
    }
}
