package chapter17;
//count number of 2's that apppear betwenn all numbers between 0 and n

public class q6 {
    //brute force
    int count2s(int n){
        int count = 0;
        for(int i=2;i<=n;i++){
            while(i != 0){
                if(i%10 == 2)
                    count++;
                i /= 10;
            }
        }
        return count;
    }
    
    int count2InRange(int number, int d){
        int pow10 = (int) Math.pow(10, d);//max numbers in that range
        int nextPow = pow10*10;
        int right = number*pow10;
        
        int roundD = number - number%nextPow;
        int roundU = number + nextPow;
        
        int digit = (number / nextPow) %10;
        
        if(digit <2)
            return roundD/10;
        if(digit > 2)
            return roundU/10;
        else
            return roundD/10 +right+1;
    }
    int count2(int n){
        int count = 0;
        int len = String.valueOf(n).length();
        for(int i = 0;i<len;i++){
            count += count2InRange(n, i);
        }
        return count;
    }
    public static void main(String[] args){}
}
