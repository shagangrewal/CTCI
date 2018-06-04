package chapter5;
//given two numbers a and b, evaluate the numbers of bits required to be flipped two make them equal

public class q6 {
    static int bitsFlipped(int a, int b){
        int count = 0;
        while(a != 0 || b != 0){
            if(a%2 != b%2)
                count++;
            a /= 2;
            b /= 2;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(bitsFlipped(-14,15));
    }
}
