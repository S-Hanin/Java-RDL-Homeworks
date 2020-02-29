package person.hanin.animal;

public class Animal<P extends IType, T extends IDescription> {
    private P type;

    private T desscription;
    public Animal(P cat, T desscription) {
        this.type = cat;
        this.desscription = desscription;
    }

    public String getType() {
        return type.getType();
    }

    public String getDesscription() {
        return desscription.getDescription();
    }
}
