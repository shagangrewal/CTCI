package chapter3;
import java.util.*;
//if stack size reach certain value, use another stack to enter the values
//follow-up: pop(int index) at a particular substack

class SetOfStacks{
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public void push(int a){
        Stack last = new Stack();
        if(last !=null ){
            last.push(a);
        }
        else{
            Stack s = new Stack();
            s.push(a);
            stacks.add(s);
        }
    }
}
//idea: create an array-list of stacks to have a lot of stacks and then keep on adding elements to each stack
//if it reaches certain level then add a new stack and add it to arraylist of stacks and add the next elements
//to this new stack
public class q3 {
    
    public static void main(String[] args){
        
    }
}
