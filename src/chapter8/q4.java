package chapter8;
import java.util.ArrayList;
//returning all subsets of a set
//finding the powerset

public class q4 {
    public static ArrayList<ArrayList<Integer>> subSet(ArrayList<Integer> a, int index){
        ArrayList<ArrayList<Integer>> allSubs;
        //base case
        if(a.size()==index){
            allSubs = new ArrayList<ArrayList<Integer>>();
            allSubs.add(new ArrayList<Integer>());
        }
        else{
            allSubs = subSet(a,index+1);
            int item = a.get(index);
            ArrayList<ArrayList<Integer>> moreSubs = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> b: allSubs){
                ArrayList<Integer> newSubs = new ArrayList<Integer>();
                newSubs.addAll(b);
                newSubs.add(item);
                moreSubs.add(newSubs);
            }
            allSubs.addAll(moreSubs);
        }
        return allSubs;
    }
    
    public static void main(String[] args){
        int a[] = {};
    }
}
