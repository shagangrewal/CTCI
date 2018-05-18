package chapter1;
import java.util.HashSet;
import java.io.*;
//Checking if all elements of a string are unique

public class q1 {
    public static boolean uniqueAll(String a){
        HashSet hs = new HashSet<String>();
        a.toLowerCase();
        for(int i=0;i<a.length();i++){
            if(hs.contains(a.charAt(i)))
                return true;
            else
                hs.add(a.charAt(i));
        }
        return false;
    }
    public static boolean Method2(String a){
        a.toLowerCase();
        for(int i=0;i<a.length()-1;i++){
            for(int j=i+1;j<a.length();j++){
                if(a.charAt(i)==a.charAt(j))
                    return true;
            }
        }
        return false;
    }
    public static boolean Method3(String a){
        int b[] = new int[128];
        if(a.length()>128)
            return false;
        for(int i=0;i<a.length();i++){
            int c = a.charAt(i);
            if(b[c]>1)
                return true;
            else
                b[c]++;
        }
        return false;
    }
    public static void main(String[] args){
        String a = "Shagan Grewal";
        if(uniqueAll(a))
            System.out.println("All elemetns are not unique");
        else
            System.out.println("All elemetns are unique");
        
        if(Method2(a))
            System.out.println("All elemetns are not unique");
        else
            System.out.println("All elemetns are unique");
        
        if(Method3(a))
            System.out.println("All elemetns are not unique");
        else
            System.out.println("All elemetns are unique");
    }
}
