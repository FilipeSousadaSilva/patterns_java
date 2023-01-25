class SubsystemA {
    public void operationA() {
        System.out.println("Performing operation A in Subsystem A");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("Performing operation B in Subsystem B");
    }
}

class SubsystemC {
    public void operationC() {
        System.out.println("Performing operation C in Subsystem C");
    }
}

class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;
    public Facade() {
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
        subsystemC = new SubsystemC();
    }
    public void operation1() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
    public void operation2() {
        subsystemB.operationB();
        subsystemC.operationC();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation1();
        facade.operation2();
    }
}
