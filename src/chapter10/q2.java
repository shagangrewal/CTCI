package chapter10;
import java.util.*;
//sort an array of strings so that all anagrams are next to each other

public class q2 {
    void sort(String[] array){
        HashMap<String, String> hmap = new HashMap<String, String>();
        
        for(String s: array){
            String key = sortChars(s);
            hmap.put(key, key);
        }
        
        //converting hashtable to array
        int index = 0;
        for(String key: hmap.keySet()){
            Set<String> ht = hmap.keySet();
            for(String t : ht){
                array[index] = t;
                index++;
            }
        }
    }
    String sortChars(String a){
        char[] con = a.toCharArray();
        Arrays.sort(con);
        return new String(con);
    }
    public static void main(String[] args){}
}
