package chapter8;
import java.util.*;
//find all the permutations of a given string given that some duplicates might occurr

public class q8 {
    ArrayList<String> getPrms(String s){
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        perms(hmap, "", s.length(), result);
        return result;
    }
    HashMap<Character, Integer> buildFreqTable(String s){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(!hm.containsKey(c))
                hm.put(c, 0);
            hm.put(c, hm.get(c)+1);
        }
        return hm;
    }
    void perms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result){
        if(remaining == 0){
            result.add(prefix);
            return;
        }
        for(char c: map.keySet()){
            int count = map.get(c);
            if(count>0){
                map.put(c, count-1);
                perms(map, prefix+c, remaining-1, result);
                map.put(c, count);
            }
        }
    }
    public static void main(String[] args){}
}
