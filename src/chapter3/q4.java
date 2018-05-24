package chapter3;
import java.util.*;
//implement a class MyQueue, implementing a queue using two stacks
class MyQ<Integer>{
    Stack s1, s2;
    MyQ(){
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void add(int a){
        s1.push(a);
    }
    public int size(){
        return s1.size()+s2.size();
    }
    public void shiftStacks(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }
    public int remove(){
        shiftStacks();
        return (int)s2.pop();
    }
    public int peek(){
        shiftStacks();
        return (int) s2.pop();
    }
}
public class q4 {
    
    public static void main(String[] args){
        
    }
}
