abstract class AbstractClass {
 
    public void templateMethod() {
        // common steps that are performed in the same order in all subclasses
        step1();
        step2();
        step3();
        // call the hook method that can be overridden in subclasses
        hookMethod();
    }
 
    public void step1() {
        // implementation of step 1
    }
 
    public void step2() {
        // implementation of step 2
    }
 
    public void step3() {
        // implementation of step 3
    }
 
    public void hookMethod() {
        // default implementation, can be overridden in subclasses
    }
}
 
class ConcreteClassA extends AbstractClass {
 
    @Override
    public void hookMethod() {
        // implementation specific to ConcreteClassA
    }
}
 
class ConcreteClassB extends AbstractClass {
 
    @Override
    public void hookMethod() {
        // implementation specific to ConcreteClassB
    }
}
