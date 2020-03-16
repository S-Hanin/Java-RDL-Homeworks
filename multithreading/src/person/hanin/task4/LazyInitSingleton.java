package person.hanin.task4;

public class LazyInitSingleton
{
    private static LazyInitSingleton instance;

    private LazyInitSingleton()
    {
        System.out.println(String.format("Lazy creation %s", this));
    }

    public static LazyInitSingleton getInstance()
    {
        if (instance == null)
        {
            synchronized (LazyInitSingleton.class)
            {
                if(instance==null)
                {
                    instance = new LazyInitSingleton();
                }

            }
        }
        return instance;
    }
}
