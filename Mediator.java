import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void send(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}

class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }
    public void send(String message) {
        mediator.send(message, this);
    }
    public void receive(String message) {
        System.out.println("Colleague A received: " + message);
    }
}

class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }
    public void send(String message) {
        mediator.send(message, this);
    }
    public void receive(String message) {
        System.out.println("Colleague B received: " + message);
    }
}

class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;
    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
    public void send(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receive(message);
            }
        }
    }
}

public class MediatorExample {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);
        colleagueA.send("Hello, how are you?");
        colleagueB.send("I'm good, thanks for asking.");
    }
}
