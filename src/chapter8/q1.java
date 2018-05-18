package chapter8;
//no ways to run n-stairs given only 1,2,or 3 hops are allowed at each step

public class q1 {
    public static int M1(int k){
        if(k<0)
            return 0;
        if(k==0)
            return 1;
        else
            return M1(k-1)+M1(k-3)+M1(k-3);
    }
    public static void main(String[] args){
        int k = 10;
        System.out.println("Method 1: "+M1(k));
    }
}
