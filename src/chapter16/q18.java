package chapter16;
import java.util.*;
//given two strings, pattern and value, pattern consists just letters a and b
//implement method if the string matches the given pattern

public class q18 {
    //method involves picking a and b, so we exactly know where to expect each string
    boolean same1(String value, String pattern){
        //checking base case if string is empty
        if(pattern.length()==0)
            return value.length()==0;
        
        //since there are only two characters involved, we can keep them as a and b
        //they can be decided upon the arrival of first character in the pattern
        char main = pattern.charAt(0);
        char alt = main == 'a'?'b':'a';
        int size = value.length();
        
        int mainCount = count(pattern, main);
        int altCount = count(pattern, alt);
        //index of first pccurrrence of alt in the string pattern
        int f_idx = pattern.indexOf(alt);
        int mainSize = size/mainCount;
        
        for(int mSize = 0;mSize<=mainSize;mSize++){
            int remaining  = size - mainSize*mainCount;
            String first = value.substring(0, mainSize);
            if(altCount ==0 || remaining%altCount == 0){
                int alt_idx = f_idx*mSize;
                int altSize = altCount == 0? 0: remaining/altCount;
                String second = altCount==0?"":value.substring(alt_idx, altSize+alt_idx);
                
                String cand = buildFromPattern(pattern, first, second);
                if(cand.equals(value))
                    return true;
            }
        }
        
        return false;
    }
    String buildFromPattern(String pattern, String a, String b){
        StringBuilder sb = new StringBuilder();
        char p = pattern.charAt(0);
        for(char c :pattern.toCharArray()){
            if(c == p)
                sb.append(a);
            else
                sb.append(b);
        }
        return sb.toString();
    }
    static int count(String p, char a){
        int count =  0;
        for(int i=0;i<p.length();i++){
            if( p.charAt(i) == a)
                count++;
        }
        return count;
    }
    boolean Method2(String pattern, String value){
        if(pattern.length()==0)
            return value.length()==0;
        
        char main = pattern.charAt(0);
        char alt = main == 'a' ? 'b' : 'a';
        
        int mC = count(pattern, main);
        int aC = count(pattern, alt);
        
        int firstAlt = pattern.indexOf(alt);
        String first = value.substring(0,mC*firstAlt);
        int rem = (value.length() - mC*first.length())/aC; // altLength
        String second = value.substring(mC*firstAlt,mC*firstAlt+rem);
        
        int fSize = (value.length()-rem*aC)/mC;
        int aSize = rem*aC;
        int k =0 ;
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)==main){
                if(value.substring(k,k+fSize) != first){
                    return false;
                }
                k += fSize;
            }
            else{
                if(value.substring(k, k+aSize) != second){
                    return false;
                }
                k += aSize;
            }
        }
        
        return true;
    }
    public static void main(String[] args){}
}
