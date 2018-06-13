package chapter17;
import java.util.Random;
//design a shuffle method, such that all 52! permutations are equally likely

public class q2 {
    int rand(int lower, int high){
        return (int)(Math.random()*(high-lower+1));
    }
    int[] shuffled(int[] cards, int i){
        if(i==0)
            return cards;
        
        shuffled(cards, i-1); //recursively solving i-1 elements till first element
        
        int k = rand(0,i); //choosing a random card to shuffle with
        
        //swapping the ith card to a randomly selected card
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;
        
        return cards;
    }
    
    //through iteration
    int[] shuffle(int cards[]){
        int  k =0;
        for(int i=0;i<cards.length;i++){
            k = rand(0,i);
            
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
        
        return cards;
    }
    public static void main(String[] args){}
}
