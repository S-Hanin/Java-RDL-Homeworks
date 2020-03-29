package Decorator;

public class Main {
    public static void main(String[] args) {
        AMatrioshka matrioshka = new Matrioshka();
        AMatrioshka blueMatrioshka = new Blue(matrioshka);
        AMatrioshka redMatrioshka = new Red(matrioshka);
        AMatrioshka purpleMatrioshka = new Purple(matrioshka);
        AMatrioshka bigRedMatrioshka = new Big(new Red(matrioshka));
        AMatrioshka bigGreenMatrioshka = new Big(new Green(matrioshka));

        System.out.println(matrioshka);
        System.out.println(blueMatrioshka);
        System.out.println(redMatrioshka);
        System.out.println(purpleMatrioshka);
        System.out.println(bigRedMatrioshka);
        System.out.println(bigGreenMatrioshka);
    }

    static class Matrioshka extends AMatrioshka {
        public Matrioshka() {
            this.name = "Матрешка";
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    static class BaseMatrioshkaDecorator extends AMatrioshka{
        private AMatrioshka wrapped;

        public BaseMatrioshkaDecorator(AMatrioshka matrioshka){
            wrapped = matrioshka;
        }

        @Override
        public String toString() {
            return String.format("%s %s", wrapped, name);
        }
    }

    static class Blue extends BaseMatrioshkaDecorator {

        public Blue(AMatrioshka matrioshka){
            super(matrioshka);
            this.name = "Синяя";
        }
    }

    static class Red extends BaseMatrioshkaDecorator {
        public Red(AMatrioshka matrioshka) {
            super(matrioshka);
            this.name = "Красная";
        }
    }

    static class Purple extends BaseMatrioshkaDecorator {
        public Purple(AMatrioshka matrioshka) {
            super(matrioshka);
            this.name = "Фиолетовая";
        }
    }


    static class Green extends BaseMatrioshkaDecorator {
        public Green(AMatrioshka matrioshka){
            super(matrioshka);
            this.name = "Зеленая";
        }
    }

    static class Big extends BaseMatrioshkaDecorator {
        public Big(AMatrioshka matrioshka) {
            super(matrioshka);
            this.name = "Большая";
        }
    }
}
