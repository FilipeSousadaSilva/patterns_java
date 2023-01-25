interface Subject {
    void request();
}

class RealSubject implements Subject {
    public void request() {
        System.out.println("Performing request on RealSubject");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;
    public Proxy() {
        realSubject = new RealSubject();
    }
    public void request() {
        System.out.println("Performing request on Proxy");
        realSubject.request();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}
