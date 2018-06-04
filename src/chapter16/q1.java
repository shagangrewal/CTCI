package chapter16;
//swap two numbers in plae(without using any temporary variables)

public class q1 {
    static void swap(int a, int b){
        System.out.println(a+"  "+b);
        a = a-b;
        b = a+b;
        a = b-a;
        System.out.println(a+"  "+b);
    }
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        //System.out.println(a+" "+b);
        swap(a,b);
        //System.out.println(a+" "+b);
    }
}
