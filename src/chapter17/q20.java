package chapter17;
import java.util.*;
//random values generated and passed to method, write method to find and maintain median of new numbers

public class q20 {
    ArrayList<Integer> b = new ArrayList<Integer>();
    PriorityQueue<Integer> minH, maxH;
    //method 1, using definition of media
    //not considering lower or upper median, just returning mean of both medians
    int median(ArrayList<Integer> a){
        Collections.sort(a);
        if(a.size()%2==0)
            return (a.get(a.size()/2-1) + a.get(a.size()/2))/2;
        else
            return (a.get(a.size()/2));
    }
    
    //more in line with the problem statement
    int meadian2(int a){
        b.add(a);
        Collections.sort(b);
        if(b.size()%2==0)
            return (b.get(b.size()/2-1) + b.get(b.size()/2))/2;
        else
            return (b.get(b.size()/2));
    }
    
    //Method 3:
    //this method involves the use of 2-heaps
    int median3(int a){
        if(maxH.size()==minH.size()){
            if(minH.peek()!=null && a>minH.peek()){
                maxH.add(minH.poll());
                minH.add(a);
            }
            else
                maxH.add(a);
        }
        else{
            if(a<maxH.peek()){
                minH.add(maxH.poll());
                maxH.add(a);
            }
            else
                minH.add(a);
        }
        
        return (int) getMedian(minH, maxH);
    }
    double getMedian(PriorityQueue<Integer> min, PriorityQueue<Integer> max){
        if(max.size() == 0)
            return 0;
        else if(max.size() == min.size())
            return (double) (max.peek()+min.peek())/2;
        else
            return max.peek();
    }
    public static void main(String[] args){}
}
