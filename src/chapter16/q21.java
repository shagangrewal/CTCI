package chapter16;
import java.util.HashSet;
//given two arrays, return two integers(one from each arary), such that swappinig them
//makes the sum of the two arrays equal

public class q21 {
    int[] findEle1(int a[], int b[]){
        if(sum(a)==sum(b))
            return null;
        int t = Math.abs(sum(a)-sum(b));
        for(int i:a){
            for(int j:b){
                if(Math.abs(i-j)==t){
                    int r[] = {i,j};
                    return r;
                }
            }
        }
        return null;
    }
    int sum(int a[]){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        return sum;
    }
    int[] findEle2(int a[], int b[]){
        if(sum(a)==sum(b))
            return null;
        HashSet<Integer> b2 = new HashSet();
        for(int i=0;i<b.length;i++){
            b2.add(b[i]);
        }
        int t = Math.abs(sum(a)-sum(b));
        for(int i=0;i<a.length;i++){
            int temp = Math.abs(a[i]-t);
            if(b2.contains(temp)){
                int r[] = {a[i],temp};
                return r;
            }
        }
        return null;
    }
    public static void main(String[] args){} 
}
