interface Prototype {
    Prototype clone();
}

class ConcretePrototypeA implements Prototype {
    private String name;
    public ConcretePrototypeA(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Prototype clone() {
        return new ConcretePrototypeA(name);
    }
}

class ConcretePrototypeB implements Prototype {
    private int value;
    public ConcretePrototypeB(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Prototype clone() {
        return new ConcretePrototypeB(value);
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Prototype prototypeA = new ConcretePrototypeA("Prototype A");
        Prototype cloneA = prototypeA.clone();
        System.out.println(cloneA.getName());

        Prototype prototypeB = new ConcretePrototypeB(1);
        Prototype cloneB = prototypeB.clone();
        System.out.println(cloneB.getValue());
    }
}
