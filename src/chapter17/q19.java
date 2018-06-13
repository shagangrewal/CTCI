package chapter17;
//given array with number 1 - N, occurring only once, find missing number in O(N) time and O(1) space
//what if there are two missing numbers

public class q19 {
    private static int n = 10;
    //1 number missing
    static int missing1(int a[]){
        int sum = 0;
        for(int i = 0;i<a.length;i++){
            sum += a[i];
        }
        return (n*(n+1))/2 - sum;
    }
    
    //2 missing numbers
    //using concepts of quadratic equations, of having sum and product and finding the numbers
    static int[] find2(int a[]){
        int sum = a[0];
        int pro = a[0];
        for(int i=1;i<a.length;i++){
            sum += a[i];
            pro += a[i]*a[i];
        }
        int s = (n*(n+1))/2 - sum;
        int p = (n*(n+1)*(2*n+1))/6 - pro;
        return solveSP(s, p);
    }
    static int[] solveSP(int s, int p){
        int t[] = {-1,-1};
        
        for(int i=1;i<s/2;i++){
            if((i*i + (s-i)*(s-i))==p){
                t[0] = i;
                t[1] = s-i;
                return t;
            }
        }
        
        return t;
    }
    public static void main(String[] args){
        int a[] = {1,2,3,5,6,7,8,9,10};
        int b[] = {1,3,4,6,7,8,9,10};
        System.out.println(missing1(a));
        int c[] = find2(b);
        System.out.println(c[0]+" "+c[1]);
    }
}
