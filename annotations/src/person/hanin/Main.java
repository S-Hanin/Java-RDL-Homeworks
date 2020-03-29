package person.hanin;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        executeTask(tasks::task1);
        executeTask(tasks::task2);
    }

    static void executeTask(Runnable method) {
        try {
            Class<?> cls = method.getClass();
            AnnotatedType[] t = cls.getAnnotatedInterfaces();
            Method meth = cls.getMethod("run");
            boolean annotated = meth.isAnnotationPresent(Wait.class);
            TimeUnit.SECONDS.sleep(1);
            new Thread(method).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static class Tasks{
        @Wait(time = 5)
        void task1() {
            System.out.println("task1 worked");
        }

        @Wait(time = 10)
        void task2(){
            System.out.println("task2 worked");
        }
    }
}
