package chapter17;
//given a histogram, evaluate its volume/ area under the curve, managed by the start to end of histogram

public class q21 {
    int computeVol(int[] histo){
        int start = 0;
        int end = histo.length-1;
        
        int max = maxIndex(histo, start, end); 
        int leftVol = subVol(histo, start, max, true);
        int rightVol = subVol(histo, max, end, false);
        
        return rightVol + leftVol;
    }
    int subVol(int a[], int start, int end, boolean left){
        if(start>=end)
            return 0;
        int sum = 0;
        if(left){
            int m = maxIndex(a, start, end-1);
            sum += borderVol(a, m, end);
            sum += subVol(a, start, m, left);
        }else{
            int m = maxIndex(a, start+1, end);
            sum += borderVol(a, start,m);
            sum += subVol(a, m,end,left);
        }
        return sum;
    }
    int maxIndex(int a[], int start, int end){
        int mi =0;
        for(int i=start+1;i<=end;i++){
            if(a[i]> a[mi])
                mi = i;
        }
        return mi;
    }
    int borderVol(int a[], int start, int end){
        if(start >= end)
            return 0;
        int sum = 0;
        int min = Math.min(a[start], a[end]);
        for(int i = start+1;i<end;i++){
            sum += min - a[i];
        }
        
        return sum;
    }
    
    //method 2:
    int vol(int hist[]){
        int leftMax[] = new int[hist.length];
        int lMax = hist[0];
        for(int i=0;i<hist.length;i++){
            int m = Math.max(lMax, hist[i]);
            leftMax[i] = m;
        }
        
        int sum = 0;
        int rMax = hist[hist.length-1];
        for(int i=hist.length-1;i>=0;i--){
            rMax = Math.max(rMax, hist[i]);
            int sTallest = Math.min(leftMax[i], hist[i]);
            
            if(sTallest > hist[i])
                sum += sTallest - hist[i];
        }
        
        return sum;
    }
    
    public static void main(String[] args){}
}
