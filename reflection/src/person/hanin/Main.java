package person.hanin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


interface IA {
}

public class Main {
    public static void main(String[] args) {
        Object[] objects = new Object[]{new A(), new B(), new AA(), new BB(), new BaseB()};
        List<Object> deprecated = findDeprecated(objects);
        System.out.println("found instances of deprecated classes:");
        deprecated.stream().forEach(System.out::println);
    }

    private static List<Object> findDeprecated(Object[] objects) {
        List<Object> result = new ArrayList<>();
        for (Object object : objects) {
            if (object.getClass().isAnnotationPresent(Deprecated.class)) {
                result.add(object);
                offerClassImplementation(objects, object);
                offerInterfacesImplementation(objects, object);
            }
        }
        return result;
    }

    private static void offerInterfacesImplementation(Object[] objects, Object object) {
        Class<?>[] interfaces = object.getClass().getInterfaces();
        if (interfaces.length == 0) return;
        List<Object> nonDeprecated = findNonDeprecatedInterfacesImplementation(interfaces, objects);
        printOffers(object, nonDeprecated);
    }

    private static void offerClassImplementation(Object[] objects, Object object) {
        Class<?> parent = object.getClass().getSuperclass();
        if (parent.getName().equals("java.lang.Object")) return;
        List<Object> nonDeprecated = findNonDeprecatedClassImplementation(parent, objects);
        printOffers(object, nonDeprecated);
    }

    private static void printOffers(Object object, List<Object> nonDeprecated) {
        if (nonDeprecated.isEmpty()) return;
        System.out.printf("%s is deprecated, use this implementation:\n",
                object.getClass());
        for (Object o : nonDeprecated) {
            System.out.printf("\t%s\n", o.getClass());
        }
    }

    private static List<Object>
    findNonDeprecatedInterfacesImplementation(Class<?>[] interfaces, Object[] objects) {
        return Arrays.stream(objects)
                .filter(o -> !o.getClass().isAnnotationPresent(Deprecated.class))
                .filter(o -> Arrays.asList(o.getClass().getInterfaces())
                        .containsAll(Arrays.asList(interfaces)))
                .collect(Collectors.toList());
    }

    private static List<Object>
    findNonDeprecatedClassImplementation(Class<?> baseClass, Object[] objects) {
        return Arrays.stream(objects)
                .filter(o -> !o.getClass().isAnnotationPresent(Deprecated.class))
                .filter(o -> baseClass.isAssignableFrom(o.getClass()))
                .collect(Collectors.toList());
    }
}

@Deprecated
class A implements IA {
}

class AA implements IA {
}

class BaseB {
}

@Deprecated
class B extends BaseB {
}

class BB extends BaseB {
}