abstract class AbstractBeverage {
  // template method
  public final void prepareBeverage() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  public abstract void brew();

  public abstract void addCondiments();

  public void boilWater() {
    System.out.println("Boiling water...");
  }

  public void pourInCup() {
    System.out.println("Pouring in cup...");
  }
}

class Tea extends AbstractBeverage {
  @Override
  public void brew() {
    System.out.println("Steeping tea leaves in water...");
  }

  @Override
  public void addCondiments() {
    System.out.println("Adding lemon...");
  }
}

class Coffee extends AbstractBeverage {
  @Override
  public void brew() {
    System.out.println("Dripping coffee through filter...");
  }

  @Override
  public void addCondiments() {
    System.out.println("Adding sugar and milk...");
  }
}

public class TemplateMethodDemo {
  public static void main(String[] args) {
    AbstractBeverage tea = new Tea();
    tea.prepareBeverage();

    System.out.println("\n");

    AbstractBeverage coffee = new Coffee();
    coffee.prepareBeverage();
  }
}
