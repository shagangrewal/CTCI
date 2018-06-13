package chapter17;
//given back to back appointments and min break after each, return optimal number of minutes
//given all consecutive appointments

public class q16 {
    //base method through recusriosn, by finding optimal of the next two appointments
    int opt(int[] app){
        return maxMins(app, 0);
    }
    int maxMins(int[] a, int ind){
        if(ind >= a.length)
            return 0;
        
        int noSkip = a[ind] + maxMins(a,ind+2); //taking current and skipping next
        int skip = maxMins(a,ind+1); //skipping the current and taking next
        
        return Math.max(noSkip, skip);
    }
    
    //method 2: using memorization rather than recursion
    int opt2(int a[]){
        int m[] = new int[a.length];
        return maxMins2(a, 0, m);
    }
    int maxMins2(int a[], int ind, int m[]){
        if(ind >= a.length)
            return 0;
        
        if(m[ind]==0){
            int noSkip = a[ind] + maxMins2(a , ind+2,m);
            int skip = maxMins2(a, ind+1, m);
            m[ind] = Math.max(skip, noSkip);
        }
        return m[ind];
    }
    
    //Method 3: through iteration
    int maxMin(int a[]){
        int[] temp = new int[a.length+2];
        temp[a.length] = 0;
        temp[a.length+1] = 0;
         
        for(int i = a.length-1;i>=0;i--){
            int noSkip = a[i] + a[i+2];
            int skip = a[i+1];
            temp[i] = Math.max(skip, noSkip);
        }
        return temp[0];
    }
    
    //Method 4: improving space complexity by not using a temporary array
    int maxMins3(int a[]){
        int oneAway = 0, twoAway = 0, current = 0, skip = 0, noSkip = 0;
        
        for(int i=a.length-1;i>=0;i--){
            noSkip = a[i] + twoAway;
            skip = oneAway;
            current = Math.max(noSkip, skip);
            oneAway = current;
            twoAway = oneAway;
        }
        return a[0];
    }
    public static void main(String[] args){}
}
