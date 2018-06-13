package chapter17;
//add two numbers without using any arithmetic operator

public class q1 {
    //using XOR and shifted and operations
    int add1(int a, int b){
        if(b==0)
            return a;
        int sum = a^b; //XOR operation
        int carry = (a & b) << 1; // shifted AND operation 
        
        return add1(sum, carry);
    }
    
    //doing the above process iteratively
    int add2(int a, int b){
        if(b == 0)
            return 0;
        while(a != 0){
            int sum = a^b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
    public static void main(String[] args){}
}
