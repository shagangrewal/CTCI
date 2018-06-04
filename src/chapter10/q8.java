package chapter10;
//given an array 1-N(n upto 32000), may have duplicates, no idea of N
//with 4 KB of memory, print all duplicate elements in an array

class BitSet{
    int[] bitset;
    
    public BitSet(int size){
        bitset = new int[(size>>5) +1]; // divided by 32
    }
    boolean get(int pos){
        int wordNum = (pos >>5); // division by 32
        int bitNum = (pos & 0x1F); //modulus by 32
        return (bitset[wordNum] & (1 << bitNum)) != 0;
    }
    void set(int pos){
        int wordNum  = pos>>5;
        int bitNum = (pos & 0x1F);
        bitset[wordNum] = 1 << bitNum;
    }
}
public class q8 {
    //4 KB = 8*4*2^10 bits
    //we can create a bit Vector with 32000 bits(2^15)== 4KB
    
    void checkDups(int[] a){
        BitSet bs = new BitSet(32000);
        for(int i=0;i<a.length;i++){
            int num = a[i];
            int num0 = num-1; //bitset starts at 0, whitle numbers at 1
            if(bs.get(num0))
                System.out.println(num);
            else
                bs.set(num0);
        }
    }
    public static void main(String[] args){}
}
