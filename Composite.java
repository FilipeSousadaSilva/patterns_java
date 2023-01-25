interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
}

class Leaf implements Component {
    public void operation() {
        System.out.println("Leaf operation");
    }
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }
}

class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
    public void add(Component component) {
        children.add(component);
    }
    public void remove(Component component) {
        children.remove(component);
    }
    public Component getChild(int index) {
        return children.get(index);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);
        composite.operation();
    }
}
