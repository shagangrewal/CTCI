package chapter16;
//find maximum of two numbers without using if-else or any comparison operator

public class q7 {
    int flip(int bit){
        return 1^bit;
    }
    int sign(int a){
        return flip((a>>31) & 0x1);
    }
    int getMax(int a, int b){
        int c = a-b;
        
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        
        //define k, =1 if a>0 and 0 otherwise
        int use_a = sa^sb;
        
        //use c if a and b are different
        int use_c = flip(sa^sb);
        
        int k = use_a*sa + use_c*sc;
        int q = sign(k);
        
        return a*k + q*b;
    }
    public static void main(String[] args){}
}
