package chapter8;
//given infinite supply of quareters, dimes, nickels and pennies
//calculate totals ways of representing n cents

public class q11 {
    static int makeChange(int n){
        int demons[] = {25,10,5,1};
        return makeChange(n, demons, 0);
    }
    static int makeChange(int amountRem,int[] demons, int index){
        if(index >= demons.length-1)
            return 1;
        int ways = 0;
        int am = demons[index];
        for(int i=0;i*am<amountRem;i++){
            int amount = amountRem - i*am;
            ways += makeChange(amount, demons, index+1);
        }
        return ways;
    }
    public static void main(String[] args){
        System.out.println(makeChange(9));
    }
}
