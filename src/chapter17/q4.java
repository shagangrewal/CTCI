package chapter17;
import java.util.ArrayList;
//array contains elements from 0->N, except for one, we cant access entire integer in A with single operation
//A's elements represented in binary, with only access is "fetch jth bit"
//write code to find missing element!!!
//follow-up, do it in O(n)

public class q4 {
    int missingNum(ArrayList<Integer> a){
        return missingNum(a,0);
    }
    int missingNum(ArrayList<Integer> a, int r){
        if(r > Integer.MAX_VALUE)
            return 0;
        
        return 0;
    }
    public static void main(String[] args){}
}
