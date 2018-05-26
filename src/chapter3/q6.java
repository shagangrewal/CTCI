package chapter3;
import java.util.*;
//animal shelter contains only dogs and cats, and you can only adopt the oldest
//you have the option either selecting the oldest or making the choice of dog or cat
//but you will always get the oldest per

abstract class Animal{
    private int order;
    private String name;
    Animal(String n){
        name = n;
    }
    public void setOrder(int a){
        order = a;
    }
    public int getOrder(){
        return order;
    }
    public boolean isOlder(Animal a){
        return this.order < a.getOrder();
    }
}
class AnimalDequeue{
    LinkedList<Dog> d = new LinkedList<Dog>();
    LinkedList<Cat> c = new LinkedList<Cat>();
    private int order = 0;
    
    public void enqueue(Animal a){
        a.setOrder(order);
        order++;
        
        if(a instanceof Dog){
            d.addLast((Dog)a);
        }
        else if(a instanceof Cat){
            c.addLast((Cat) a);
        }
    }
    
    public Animal dequeueAny(Animal a){
        if(d.size()==0)
            return dequeueCats();
        if(c.size()==0)
            return dequeueDogs();
        
        Dog dg = d.peek();
        Cat ct = c.peek();
        
        Animal result = dg.isOlder(ct)?dg:ct;
        return result;
    }
    public Dog dequeueDogs(){
        return d.poll();
    }
    public Cat dequeueCats(){
        return c.poll();
    }
}

class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
}
class Cat extends Animal{
    public Cat(String a){
        super(a);
    }
}
public class q6 {
    public static void main(String[] args){}
}
