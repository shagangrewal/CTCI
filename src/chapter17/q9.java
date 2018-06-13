package chapter17;
import java.util.*;
//find k-th multiple, such that only prime factors are 3,5,7
//3,5,7 do not have to be factors, but it cant have any other factors which are prime

public class q9 {
    //Method 1:
    int removeMin(Queue<Integer> q){
        int min = q.peek();
        for(Integer v: q){
            if(min > v)
                min = v;
        }
        while(q.contains(min)){
            q.remove(min);
        }
        return min;
    }
    void addProducts(Queue<Integer> q, int v){
        q.add(3*v);
        q.add(5*v);
        q.add(7*v);
    }
    int getKNumber(int k){
        if(k<0)
            return 0;
        
        int val = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        addProducts(q,1);
        for(int i=0;i<k;i++){
            val = removeMin(q);
            addProducts(q, val);
        }
        return val;
    }
    
    //Method 2: optimal
    //creating 3 diffrent queues for 3,5 and 7 and managing them according to the minimum value
    int kthnum(int k){
        if(k<=0)
            return 0;
        
        int val = 0;
        
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        Queue<Integer> q7 = new LinkedList<Integer>();
        
        for(int i=0;i<k;i++){
            int v3 = q3.peek() >0 ? q3.peek(): Integer.MAX_VALUE;
            int v5 = q5.peek() >0 ? q5.peek(): Integer.MAX_VALUE;
            int v7 = q7.peek() >0 ? q7.peek(): Integer.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));
            
            if(val == v3){
                q3.remove();
                q3.add(val*3);
                q5.add(val*5);
            }
            else if(val == v5){
                q5.remove();
                q5.add(val*5);
            }else{
                q7.remove();
            }
            q7.add(val*7);
        }
        return val;
    }
    public static void main(String[] args){}
}
