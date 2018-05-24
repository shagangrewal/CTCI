package chapter3;
import java.util.*;
//design stack to have a function called min, operating at O(1) time

public class q2 {
    static Stack<Integer> s = new Stack<Integer>(); //the basic stack to puch values
    static Stack<Integer> s2 = new Stack<Integer>(); //the second stack to keep track of the min value
    int min = Integer.MAX_VALUE;
    
    public void push(int a){
        if(a<min){
            s2.push(a);
        }
        s.push(a);
    }
    int min(){
        if(s2.isEmpty())
            return Integer.MAX_VALUE;
        else
            return s2.pop();
    }
    public static void main(String[] args){
        //designing the algo for a fuction min returning value in O(1) time
        s.push(10);
        s2.push(10);
        s.push(3);
        s.push(7);
        s.push(1);
        //s.min();
        
    }
}
