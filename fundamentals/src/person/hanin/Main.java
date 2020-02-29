package person.hanin;

import person.hanin.animal.Animal;

public class Main {
    public static void main(String[] args) {
        String animalType = args.length > 0 ? args[0]: "other";
        Animal animal = getAnimalByType(animalType);
        System.out.println(animal.getDesscription());
    }

    private static Animal getAnimalByType(String type) {
        switch (type.toLowerCase()) {
            case "cat":
                return new Animal<>(() -> "Cat", () -> "Cat says 'meow' and catch mice");
            case "dog":
                return new Animal<>(() -> "Dog", () -> "Dog says 'woof' and protect house");
            case "hedgehog":
                return new Animal<>(() -> "Hedgehog", () -> "Hedgehog says 'frr' and catch mice");
            default:
                return new Animal<>(() -> "Unknown", () -> "Unknown");
        }
    }
}
