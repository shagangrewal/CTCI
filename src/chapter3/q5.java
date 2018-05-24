package chapter3;
import java.util.*;
//implement a stack such that the smallest items are at top

public class q5 {
    static Stack<Integer> s = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();
    
    static void push(int a){
        s.push(a);
    }
    public static void sort(){
        while(!s.isEmpty()){
            s2.push(s.pop());
        }
        s.push(s2.pop());
        while(!s2.isEmpty()){
            if(s2.peek()>s.peek()){
                int temp = s.pop();
                s.push(s2.pop());
                s.push(temp);
            }
            else{
                s.push(s2.pop());
            }
        }
    }
    public static void main(String[] args){
        s.push(10);
        s.push(2);
        s.push(17);
        s.push(9);
        s.push(5);
        sort();
        System.out.println(s.pop());
        //System.out.println(s.pop());
        //System.out.println(s.pop());
    }
}
