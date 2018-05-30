package chapter10;
//given a sorted array, that has been rotated unknown number of times
//implement a method to find an element in the array

public class q3 {
    int search(int a[], int left, int right, int x){
        int mid = (left+right)/2;
        if(a[mid]==x)
            return mid;
        if(left>right)
            return -1;
        if(a[left]<a[mid]){//this implies left side is correctly sorted
            if(x>=a[left] && x<a[mid])
                return search(a, left, mid-1, x);
            else
                return search(a, mid+1, right, x);
        }
        else if(a[mid]<a[left]){ //right part is in correct form
            if(x<a[right] && x>=a[mid])
                return search(a, mid+1, right, x);
            else
                return search(a, left, mid-1, x);
        }
        else if(a[mid]==a[left]){//all elements on the left side are same
            if(a[mid] != a[right]){
                return search(a, mid+1, right, x);
            }
            else{
                int result = search(a, left, mid-1,x);
                if(result == -1){
                    return search(a, mid+1, right, x);
                }
                else{
                    return result;
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args){}
}
