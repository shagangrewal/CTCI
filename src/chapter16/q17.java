package chapter16;
//given an array, find max continuous sum in an array, i.e the max running sum

public class q17 {
    int maxRSum(int a[]){
        //in this case returning 0, if the running sum at any stage is not >0
        int maxS = 0;
        int sum = 0;//keeps track of the running sum
        for(int i=0;i<a.length;i++){
            sum += a[i];
            if(sum>maxS)
                maxS = sum;
            else
                sum = 0;
        }
        return maxS;
    }
    public static void main(String[] args){}
}
