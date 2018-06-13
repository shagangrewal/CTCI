package chapter17;
import java.util.*;
//given a file, find shortest distance between two words, in terms of numbers of words in between
//if this is opreated multiple times, then how to optimize the solution

public class q11 {
    //shortest dist: distance between any two occurrences of the two words
    int shortestDist(String[] w, String w1, String w2){
        int loc1 = Integer.MAX_VALUE, loc2 = Integer.MAX_VALUE;
        int minD = Integer.MAX_VALUE;
        for(int i=0;i<w.length;i++){
            if(w[i]==w1){
                loc1 = i;
                if(minD > Math.abs(loc1 - loc2))
                    minD = Math.abs(loc1 - loc2);
            }
            else if(w[i] == w2){
                loc2 = i;
                if(minD > Math.abs(loc1 - loc2))
                    minD = Math.abs(loc1 - loc2);
            }
        }
        return minD;
    }
    
    //if the whole prcess is done multiple times then we can set up a Hashtable containing the word and 
    //all the locations it occurs at
    
    //setting up a hashtable so as to access locations of each word in the string file
    HashMap<String, ArrayList<Integer>> locations(String[] words){
        HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
        for(int i =0;i<words.length;i++){
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(i);
            hm.put(words[i], a);
        }
        return hm;
    }
    
    int minimum(String w1, String w2, HashMap<String, ArrayList<Integer>> hm){
        ArrayList<Integer> a1 = hm.get(w1);
        ArrayList<Integer> a2 = hm.get(w2);
        return minDistance(a1,a2);
    }
    
    int minDistance(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a==null || b==null || a.size()==0 || b.size()==0)
            return 0;
        int min = Integer.MAX_VALUE;
        
        int a1 = 0;
        int b1 = 0;
        
        while(a1<a.size() && b1<b.size()){
            if(min > Math.abs(a.get(a1)-b.get(b1))){
                min = Math.abs(a.get(a1)-b.get(b1));
            }
            
            if(a1<b1)
                a1++;
            else
                b1++;
        }
        
        return min;
    }
    public static void main(String[] args){}
}
