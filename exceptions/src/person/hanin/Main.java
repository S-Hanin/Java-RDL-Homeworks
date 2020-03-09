package person.hanin;

public class Main {
    public static void main(String[] args) {
        //TODO task2: my own AutoCloseable usage
        try (CloseableResource myCloseable = new CloseableResource()) {
            myCloseable.doSomethingUseful();
        } catch (io.humb1t.Main.MyShinyMetalException e) {
            e.printStackTrace();
        }

        //TODO task3
        //we should initialize local variable
        ClassWithBadConstructor broken = null;
        try {
            broken = new ClassWithBadConstructor();
        } catch (io.humb1t.Main.MyShinyMetalException e) {
            e.printStackTrace();
        }
        //it'll be an compile time error without initialization
        //prints `null`
        System.out.println(broken);
    }
}
