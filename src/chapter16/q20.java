package chapter16;
import java.util.*;
//given a list of numbers, write a method to return all possible valid words that can be formed
//using the given number on an old analog mobile phone


public class q20 {
    char[][] k9 = {null,null,{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
                    {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    ArrayList<String> validWOrds(String number, HashMap<String, String> dict){
        ArrayList<String> a = new ArrayList<String>();
        a.add(dict.get(number));
        return a;
    }
    //creating hashtable that maps number to all possible representations
    HashMap<String, String> initDict(String[] words){
        //hashmap from integer to digit
        HashMap<Character, Character> hm = createLetter();
        HashMap<String, String> wordNum = new HashMap<String, String>();
        
        for(String w: words){
            String num = convert(w,hm);
            wordNum.put(num, w);
        }
        return wordNum;
    }
    //number->letter into letter->number
    HashMap<Character, Character> createLetter(){
        HashMap<Character, Character> hmap = new HashMap<Character, Character>();
        for(int i=0;i<k9.length;i++){
            char[] letters = k9[i];
            if(letters != null){
                for(char l : letters){
                    char c = Character.forDigit(i, 10);
                    hmap.put(l, c);
                }
            }
        }
        return hmap;
    }
    //convert string to its representation in the mobile keyboard format
    String convert(String word, HashMap<Character,Character> a){
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            if(a.containsKey(c)){
                char digit = a.get(c);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){}
}
