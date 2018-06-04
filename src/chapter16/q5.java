package chapter16;
//write an algorithm to compute the trailing zeroes in a factorial number

public class q5 {
    //Method 1:
    static int factorOf5(int num){
        int count = 0;
        while(num%5 ==0){
            count++;
            num/=5;
        }
        return count;
    }
    static int noOfZero(int num){
        if(num<0)
            return -1;
        int count = 0;
        for(int i=2;i<=num;i++){
            count += factorOf5(i);
        }
        return count;
    }
    
    //Method 2: rather individually going throught it, we directly count factors of 5 and return them
    static int noZeros(int num){
        int count = 0;
        if(num<0)
            return -1;
        else if(num<5)
            return 0;
        else{
            for(int i=5;num/i>0;i*=5){
                count += num/i;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(noOfZero(205));
        System.out.println(noZeros(205));
    }
}
