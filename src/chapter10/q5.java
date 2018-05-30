package chapter10;
//given sorted array interspersed with empty strings, write method to find location of a string
public class q5 {
    int location(String[] a, String x, int first, int last){
        if(first>last)
            return -1;
        
        int mid = (first+last)/2;
        
        if(a[mid].isEmpty()){
            int left = mid-1;
            int right = mid+1;
            while(true){
                if(left<first && right>last)
                    return -1;
                else if(right<=last && !a[right].isEmpty()){
                    mid = right;
                    break;
                }
                else if(left>=first && !a[left].isEmpty()){
                    mid = left;
                    break;
                }
                left--;
                right++;
            }
        }
        if(x.endsWith(a[mid]))
            return mid;
        else if(a[mid].compareTo(x)>0){
            return location(a, x, first, mid-1);
        }
        else
            return location(a, x, mid+1, last);
    }
    int search(String[] str, String b){
        if(str==null || b==null || b=="")
            return -1;
        return location(str, b, 0, str.length-1);
    }
    public static void main(String[] args){}
}
