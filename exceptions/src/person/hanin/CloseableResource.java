package person.hanin;

import io.humb1t.Main;

//TODO task2: Create your own implementation of java.lang.AutoCloseable interface
public class CloseableResource implements AutoCloseable {
    void doSomethingUseful() {
        System.out.println("Do some useful work");
    }

    @Override
    public void close() throws Main.MyShinyMetalException {
        System.out.println("Close method executed");
    }
}
