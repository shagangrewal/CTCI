package chapter16;
import java.util.*;
//desing method to find the frequency of a given word in a book

public class q2 {
    //general case where we evaluate the frequency of each word and store them 
    void setFreq(String[] a){
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        for(String t :a){
            if(!hmap.containsKey(t)){
                hmap.put(t, 1);
            }
            else{
                int count = hmap.get(t);
                hmap.put(t, hmap.get(t)+1);
            }
        }
    }
    //if we are looking for a particular word
    int freq(String[] a, String b){
        int count = 0;
        for(String s : a){
            if(s==b)
                count++;
        }
        return count;
    }
    public static void main(String[] args){}
}
