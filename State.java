interface State {
    void handle();
}

class ConcreteStateA implements State {
    public void handle() {
        System.out.println("Handling in Concrete State A");
    }
}

class ConcreteStateB implements State {
    public void handle() {
        System.out.println("Handling in Concrete State B");
    }
}

class Context {
    private State state;

    public Context() {
        state = new ConcreteStateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle() {
        state.handle();
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.handle(); // Output: Handling in Concrete State A
        context.setState(new ConcreteStateB());
        context.handle(); // Output: Handling in Concrete State B
    }
}
