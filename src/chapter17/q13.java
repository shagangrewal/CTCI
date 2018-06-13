package chapter17;
import java.util.*;
//accidently we removed spaces, punctutation and capitalization in word document
//given a dictionary and document, we design an algorithm to minimize number of unknown words(not in dictionary)

public class q13 {
    //using recursion, we select place where first space is inserted, it can be first, second and so on
    //we select best with minimum number of invalid characters
    //Brute Force:
    private class ParseResult{
        int invalid = Integer.MAX_VALUE;
        String parsed = " ";
        ParseResult(int v, String p){
            invalid = v;
            parsed = p;
        }
    }
    String bestCase(HashSet<String> dict, String w){
        ParseResult r = spl(dict, w, 0);
        return r==null ? null : r.parsed;
    }
    ParseResult spl(HashSet<String> dict, String w, int start){
        if(start > w.length())
            return new ParseResult(0,"");
        
        int bInv = Integer.MAX_VALUE;
        String bP = null;
        String partial = "";
        int ind = start;
        
        while(ind < w.length()){
            char c = w.charAt(ind);
            partial += c;
            int invalid = dict.contains(partial) ? 0 : partial.length();
            
            if(invalid < bInv){
                //recurse using a space
                ParseResult s = spl(dict, w, ind+1);
                if(s.invalid+invalid < bInv){
                    bInv = s.invalid + invalid;
                    bP = partial +" " + s.parsed;
                    if(bInv==0)
                        break;
                }
            }
            ind++;
        }
        return new ParseResult(bInv, bP);
    }
    
    
    //method 2: without using recursion, where it is exponential complexity
    String bestSpl(HashSet<String> dict, String w){
        ParseResult[] pr = new ParseResult[w.length()];
        ParseResult r = split(dict, w, 0, pr);
        
        return r==null ? null : r.parsed;
    }
    ParseResult split(HashSet<String> dict, String w, int start, ParseResult[] m){
        if(start >= w.length())
            return new ParseResult(0,"");
        
        if(m[start] != null)
            return m[start];
        
        int bInv = Integer.MAX_VALUE;
        String bP = null;
        String partial = "";
        int ind = start;
        
        while(ind < w.length()){
            char c = w.charAt(ind);
            partial += c;
            int inv = dict.contains(c) ? 0 : partial.length();
            if(inv < bInv){
                ParseResult r = split(dict, w, ind+1, m);
                if(inv + r.invalid < bInv){
                    bInv = inv + r.invalid;
                    bP = partial +" " + r.parsed;
                    if(bInv == 0)
                        break;
                }
            }
            ind++;
        }
        
        m[start] = new ParseResult(bInv, bP);
        return m[start];
    }
    public static void main(String[] args){}
}
