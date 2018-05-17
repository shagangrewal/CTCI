package chapter1;
import java.util.Arrays;
//chcking if a given string is a permutation of another string
//check if the case sensitivity is important or not

public class q2 {
    public static boolean perm1(String a, String b){
        if(a.length() != b.length())
            return false;
        char[] c = a.toCharArray();
        char[] f = b.toCharArray();
        int d[] = new int[128];
        for(char e:c){
            d[e]++;
        }
        for(int i=0;i<b.length();i++){
            int m = (int) b.charAt(i);
            d[m]--;
            if(d[m]<0)
                return false;
        }
        return true;
    }
    public static boolean perm2(String a, String b){
        if(a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        char c[] = a.toCharArray();
        char d[] = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        for(int i=0;i<a.length();i++){
            if(c[i]!=d[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String a = "dog";
        String b = "God";
        System.out.println("This is case sensitive result");
        if(perm1(a,b))
            System.out.println("Yes, they are permutations of each other");
        else
            System.out.println("No, they are not the permutations of each other");
        System.out.println("\n"+"This is not case sensitive");
        if(perm2(a,b))
            System.out.println("Yes, they are permutations of each other");
        else
            System.out.println("No, they are not the permutations of each other");
    }
}
