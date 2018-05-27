package chapter4;
import java.util.*;
//print all given arrays that could have led to this final BST

public class q9 {
    ArrayList<LinkedList<Integer>> allSequence(TNode a){
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        
        if(a==null){
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(a.data);
        
        ArrayList<LinkedList<Integer>> leftSeq = new ArrayList<LinkedList<Integer>>();
        ArrayList<LinkedList<Integer>> rightSeq = new ArrayList<LinkedList<Integer>>();
        
        for(LinkedList<Integer> left : leftSeq){
            for(LinkedList<Integer> right : rightSeq){
                ArrayList<LinkedList<Integer>> weave = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weave, prefix);
                result.addAll(weave);
            }
        }
        return result;
    }
    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        if(first.size()==0 || second.size()==0){
            LinkedList<Integer> res = (LinkedList<Integer>) prefix.clone();
            res.addAll(first);
            res.addAll(second);
            results.add(res);
            return;
        }
        int headf = first.removeFirst();
        prefix.addLast(headf);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headf);
        
        int headS = second.removeFirst();
        prefix.addLast(headS);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headS);
    }
    public static void main(String[] args){}
}
