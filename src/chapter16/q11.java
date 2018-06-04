package chapter16;
import java.util.*;
//designing diving board with two sets of planks(1 shorter, 1 longer)
//need to use max k boarsd, need all possible lengths of boards

public class q11 {
    HashSet<Integer> lengths(int k, int longer, int shorter){
        HashSet<Integer> lengths = new HashSet<Integer>();
        allLengths(lengths, k, shorter, longer, 0);
        return lengths;
    }
    void allLengths(HashSet<Integer> lengths, int k, int shorter, int larger, int total){
        if(k==0){
            lengths.add(total);
            return;
        }
        allLengths(lengths, k-1, shorter, larger, total+shorter);
        allLengths(lengths, k-1, shorter, larger, total+larger);
    }//this will result in a lot of overlapping problems
    
    //Method 2: we will simply do by going through base method
    HashSet<Integer> len(int k, int shorter, int longer){
        HashSet<Integer> l = new HashSet<Integer>();
        //int a[] = new int[k+1];
        int nL = 0;
        int tL = 0;
        for(int i=0;i<=k;i++){
            nL = k-i;
            tL = i*shorter + nL*longer;
            l.add(tL);//rather than using a HashSet, we can also use array since we know the number we are going to run the loop
            //a[i] = tL;
        }
        
        return l;
    }
    
    //Method 3: we can track if we need to process that particular evaluar or not
    HashSet<Integer> lens(int k, int shorter, int longer){
        HashSet<Integer> allL = new HashSet<Integer>();
        HashSet<String> visited = new HashSet<String>();
        all(k, shorter, longer, allL, visited, 0);
        return allL;
    }
    void all(int k, int shorter, int longer, HashSet<Integer> allL, HashSet<String> s, int total){
        if(k==0){
            allL.add(total);
            return;
        }
        String key = k+" "+total;
        if(!s.contains(key)){
            all(k-1, shorter, longer, allL, s, total+shorter);
            all(k-1, shorter, longer, allL, s, total+longer);
            s.add(key);
        }
        else{
            return;
        }
    }
    public static void main(String[] args){}
}
