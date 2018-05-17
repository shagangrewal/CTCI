package chapter1;
//checking a  string if it is a permutation of palindrome 

public class q4 {
    public static void checkPerm(String a){
        int c[] = new int[128];
        a = a.toLowerCase();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==' ')
                continue;
            else{
                int d = (int) a.charAt(i);
                c[d]++;
            }
        }
        int m =0;
        for(int i=0;i<128;i++){
            if(c[i]%2!=0)
                m += c[i]%2;
        }
        if(m==0 || m==1)
            System.out.println("It is a palindrome");
        else
            System.out.println("It is not a palindrome");
    }
    
    public static void main(String[] args){
        String a = "tactcoapapa";
        checkPerm(a);
    }
}
