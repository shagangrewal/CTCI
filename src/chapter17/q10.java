package chapter17;
//find the majority element, which takes up more than half of the elements in an array
//do it in O(N) time and O(1) space

public class q10 {
    //Brute force
    int majority(int a[]){
        int count = 0;
        int m = a.length/2;
        for(int i = 0;i<a.length;i++){
            int k = a[i];
            for(int j = 0; j<a.length && j!= i;j++){
                if(a[j]==k)
                    count++;
                if(count>=m)
                    return k;
            }
        }
        return -1;
    }
    
    //Method 2: brute force
    int major(int a[]){
        return -1;
    }
    boolean valid(int a[], int k){
        int count = 0;
        for(int i : a){
            if( i == k)
                count++;
        }
        return count>=a.length/2;
    }
    
    //both of the above methods are in O(N^2), which are slower than required
    int findMajor(int a[]){
        int m = majorEle(a);
        return valid(a,m) ? m:-1;
    }
    int majorEle(int a[]){
        int major = 0;
        int count = 0;
        
        for(int i : a){
            if(count == 0)
                major = i;
            
            if(i == major)
                count++;
            else
                count--;
        }
        return major;
    }
    public static void main(String[] args){}
}
