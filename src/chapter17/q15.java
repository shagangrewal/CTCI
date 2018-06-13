package chapter17;
import java.util.*;
//given a list of words, find longest word made of other words

public class q15 {
    //Brute force method
    //put all the words in the map, and then check if the substring  is contained in map(both sides of string)
    String longest(String[] ws){
        HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
        
        for(String str : ws){
            hm.put(str, true);
        }
        String max = ws[0];
        //now we process each string, by diving in sublengths
        for(String s : ws){
            for(int i = 1;i<s.length();i++){
                String l = s.substring(0,i);
                String r = s.substring(i,s.length()-1);
                if(hm.get(r) && hm.get(l)){
                    if(s.length() > max.length())
                        max = s;
                }
            }
        }
        
        return max;
    }
    
    
    public static void main(String[] args){}
}
