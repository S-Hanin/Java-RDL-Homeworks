package person.hanin;

import io.humb1t.Main;

//TODO task3: Create a new class. Implement constructor which should throw an exception during execution
class ClassWithBadConstructor {
    ClassWithBadConstructor() throws io.humb1t.Main.MyShinyMetalException {
        throw new Main.MyShinyMetalException();
    }
}
