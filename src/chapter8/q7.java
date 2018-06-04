package chapter8;
import java.util.ArrayList;
//write method to compute all permutations of a string, containing unique characters

public class q7 {
    ArrayList<String> getPerms(String s){
        if(s == null)
            return null;
        ArrayList<String> perms = new ArrayList<String>();
        if(s.length()==0){
            perms.add("");
            return perms;
        }
        if(s.length()==1)
            perms.add(s);
        
        char c  = s.charAt(0);
        String rem = s.substring(1,s.length());
        ArrayList<String> words = getPerms(rem);
        
        for(String word:words){
            for(int i=0;i<word.length();i++){
                String sub = insertCharAt(word, c, i); 
                perms.add(sub);
            }
        }
                
        return perms;
    }
    
    String insertCharAt(String word, char c, int i){
        String s = word.substring(0,i);
        String sr = word.substring(i+1,word.length());
        return s+c+sr;
    }
    
    
    //Method:2
    ArrayList<String> getPermutations(String s){
        if(s==null)
            return null;
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i<s.length();i++){
            String before = s.substring(0,i);
            String after = s.substring(i+1,s.length());
            ArrayList<String> temp = getPermutations(before+after);
            
            for(String st: temp){
                result.add(s.charAt(i)+st);
            }
        }
        return result;
    }
    public static void main(String[] args){
        
    }
}
