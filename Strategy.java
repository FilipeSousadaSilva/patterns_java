interface PaymentStrategy {
    public void pay(double amount);
}

class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expirationDate;
    
    public CreditCardStrategy(String name, String cardNumber, String cvv, String expirationDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }
    
    public void pay(double amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public void pay(double amount) {
        System.out.println(amount + " paid with PayPal.");
    }
}

class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;
    
    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }
    
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    
    public double calculateTotal() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void pay() {
        double amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        Item item1 = new Item("shirt", 25.00);
        Item item2 = new Item("pants", 35.00);
        
        cart.addItem(item1);
        cart.addItem(item2);
        
        //set payment strategy
        cart.setPaymentStrategy(new CreditCardStrategy("John Doe", "1234567890", "123", "01/2022"));
        
        //pay
        cart.pay();
        
        //change payment strategy
        cart.setPaymentStrategy(new PayPalStrategy("johndoe@email.com", "password123"));
        
        //pay
        cart.pay();
    }
}
