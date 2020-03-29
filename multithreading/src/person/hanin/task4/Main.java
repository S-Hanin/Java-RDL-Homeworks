package person.hanin.task4;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException{
/*        Ранняя загрузка:
            + ошибки, возможные при создании объекта, возникнут на этапе запуска приложения
            + потокобезопасна, jvm следит чтобы класс был загружен один раз.
            - время запуска приложения увеличивается

          Поздняя загрузка:
            + уменьшается время запуска приложения
            - возможность возникновения ошибки в рантайме
            - замедление работы приложения при создании объекта
*/

        try {
            // load class by hand so we see eager singleton initialization
            Class<?> eagerInitSingletonClass = Class.forName("person.hanin.task4.EagerInitSingleton");
            Class<?> lazyInitSingletonClass = Class.forName("person.hanin.task4.LazyInitSingleton");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ExecutorService pool = Executors.newFixedThreadPool(3);
        TimeUnit.SECONDS.sleep(3);
        Runnable task1 = () -> {
            // this singleton instance was created when EagerInitSingleton class was loaded by jvm
            EagerInitSingleton s = EagerInitSingleton.instance;
            System.out.println(s);
        };
        IntStream.range(0, 3).forEach(x -> pool.execute(task1));

        TimeUnit.MILLISECONDS.sleep(10);

        Runnable task2 = () -> {
            LazyInitSingleton s = LazyInitSingleton.getInstance();
            System.out.println(s);
        };
        IntStream.range(0, 3).forEach(x -> pool.execute(task2));
        pool.shutdown();
    }
}
