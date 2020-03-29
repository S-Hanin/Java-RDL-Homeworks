package person.hanin.task4;

public class EagerInitSingleton {
    // this initialization happens when this class will be loaded by jvm
    public static final EagerInitSingleton instance = new EagerInitSingleton();

    private EagerInitSingleton()
    {
        System.out.println(String.format("Eager creation %s", this));
    }

    public EagerInitSingleton getInstance(){
        return instance;
    }
}
