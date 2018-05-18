package chapter8;
//mutiply two elements without using '*' operator

public class q5 {
    public static int mult1(int a, int b){
        if(b==0)
            return 0;
        else{
            return a+mult1(a,b-1);
        }
    }
    public static int mult2(int a, int b){
        int k = a;
        if(b==0)
            return 0;
        while(b>1){
            k += a;
            b--;
        }
        return k;
    }
    public static int mult3(int a, int b){
        int c[] = new int[b];
        c[0] = a;
        for(int i=1;i<b;i++){
            c[i] = c[i-1]+a;
        }
        return c[b-1];
    }
    public static int mult4(int a, int b){
        if(b==0)
            return 0;
        if(b==1)
            return a;
        if(a%2==0){
            return 2*mult1(a/2,b);
        }
        else{
            return 2*mult1(a/2,b)+a;
        }
    }
    public static void main(String[] args){
        int a=10,b=5;
        System.out.println(mult1(a,b));
        System.out.println(mult2(a,b));
        System.out.println(mult3(a,b));
        System.out.println(mult4(a,b));
    }
}
