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
        // if instance is not null then we don't need synchronize anything
        if (instance == null)
        {
            synchronized (LazyInitSingleton.class)
            {
                // we make check one more time because several threads can step into first "if" block
                if(instance==null)
                {
                    instance = new LazyInitSingleton();
                }

            }
        }
        return instance;
    }
}
