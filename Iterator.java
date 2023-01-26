import java.util.Iterator;

public class MyCollection<E> implements Iterable<E> {
    private E[] elements;
    private int size;

    public MyCollection(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E element) {
        elements[size++] = element;
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        int index;

        public boolean hasNext() {
            return index < size;
        }

        public E next() {
            return elements[index++];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> collection = new MyCollection<>(5);
        collection.add(1);
        collection.add(2);
        collection.add(3);

        for (Integer i : collection) {
            System.out.println(i);
        }
    }
}
