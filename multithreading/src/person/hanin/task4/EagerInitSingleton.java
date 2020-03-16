package person.hanin.task4;

public class EagerInitSingleton {
    public static final EagerInitSingleton instance = new EagerInitSingleton();

    private EagerInitSingleton()
    {
        System.out.println(String.format("Eager creation %s", this));
    }

    public EagerInitSingleton getInstance(){
        return instance;
    }
}
