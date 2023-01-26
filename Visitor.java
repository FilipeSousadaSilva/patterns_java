interface Visitor {
    void visit(Book book);
    void visit(CD cd);
    void visit(DVD dvd);
}

abstract class Item {
    String name;
    double price;
    abstract void accept(Visitor visitor);
}

class Book extends Item {
    String author;
    int pages;
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CD extends Item {
    String artist;
    int tracks;
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class DVD extends Item {
    String director;
    int length;
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ItemVisitor implements Visitor {
    double totalPrice;
    void visit(Book book) {
        totalPrice += book.price;
    }
    void visit(CD cd) {
        totalPrice += cd.price;
    }
    void visit(DVD dvd) {
        totalPrice += dvd.price;
    }
}

class Main {
    public static void main(String[] args) {
        Item[] items = {new Book("Java Programming", 20.99, "John Doe", 500), 
                        new CD("Greatest Hits", 14.99, "John Doe", 15),
                        new DVD("The Shawshank Redemption", 14.99, "Frank Darabont", 142)};
        ItemVisitor visitor = new ItemVisitor();
        for (Item item : items) {
            item.accept(visitor);
        }
        System.out.println("Total price of all items: " + visitor.totalPrice);
    }
}
