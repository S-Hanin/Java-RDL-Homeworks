package io.humb1t;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = new Order().getClass();
        Class os = OrderStatus.PROCESSING.getClass();
        Class primitiveClass = boolean.class;
        Class orderClassByName = Class.forName("io.humb1t.Order");
//        Class arrayClassByStrangeName = Class.forName("[L.io.humb1t.Order;");
        Class voidClass = Void.TYPE;

        final Class<Processor> processorClass = Processor.class;
        System.out.println("Canonical name: " + processorClass.getCanonicalName());
        System.out.println("Modifiers: " + Modifier.toString(processorClass.getModifiers()));
        System.out.println("Type parameters:");
        for (TypeVariable<Class<Processor>> typeParameter : processorClass.getTypeParameters()) {
            System.out.println(typeParameter);
        }

        try {
            Class mainClass = Main.class;
            Method mainMethod = mainClass.getMethod("main", String[].class);
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }

        try {
            Class<?> mainClass = Main.class;
            Method mainMethod = mainClass.getMethod("main", String[].class);
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }

        Class<?> classWithPrivateNoArgsConstructor = Class.forName("io.humb1t.ClassWithPrivateNoArgsConstructor");
        try {
            classWithPrivateNoArgsConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Constructor<?> method = classWithPrivateNoArgsConstructor.getDeclaredConstructor();
            method.setAccessible(true);
            ClassWithPrivateNoArgsConstructor a =
                    (ClassWithPrivateNoArgsConstructor) method.newInstance();
            System.out.println(a.txt);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

enum OrderStatus {
    PROCESSING
}

class Order {

}

class Processor<E> {
    E processingElement;
}

class ClassWithPrivateNoArgsConstructor {
    String txt = "We have an instance of class with private constructor";
    private ClassWithPrivateNoArgsConstructor(){
    }
}
