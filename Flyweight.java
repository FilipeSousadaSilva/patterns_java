interface Flyweight {
    void operation(int extrinsicState);
}

class ConcreteFlyweight implements Flyweight {
    private int intrinsicState;
    public ConcreteFlyweight(int intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    public void operation(int extrinsicState) {
        System.out.println("Intrinsic State : " + intrinsicState +
                ", Extrinsic State : " + extrinsicState);
    }
}

class FlyweightFactory {
    private Map<Integer, Flyweight> flyweights = new HashMap<>();
    public Flyweight getFlyweight(int key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}

public class FlyweightPattern {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight(1);
        Flyweight flyweight2 = factory.getFlyweight(2);
        Flyweight flyweight3 = factory.getFlyweight(1);
        flyweight1.operation(1);
        flyweight2.operation(2);
        flyweight3.operation(3);
    }
}
