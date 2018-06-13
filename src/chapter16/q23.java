package chapter16;
import java.util.Random;
//implement rand7() function from rand5() function

public class q23 {
    static int rand5(){
        Random r = new Random();
        int c = r.nextInt(5);
        return c;
    }
    int rand7(){
        while(true){
            int n = 5*rand5() + rand5();
            if(n<21){
                return n%7;
            }
        }
    }
    
    //method2
    int rand7_2(){
        while(true){
            int r1 = 2*rand5();
            int r2 = rand5();
            if(r2 != 4){
                r2 = r2%2;
                int n = r1+r2;
                return n%7;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(rand5());
    }
}
