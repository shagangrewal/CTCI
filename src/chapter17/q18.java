package chapter17;
//given a shorter array and a longer array, find the shortest subarray in the longer one, where all
//elements of shorter array exist, the elements can occur in any order

public class q18 {
    //Method 1: brote force method
    int[] shortR(int b[], int s[]){
        int r[] = new int[2]; //r[0[ corresponds to smaller ind and r[1] to end ofindices
        int bS = -1;
        int bE = -1;
        
        for(int i=0;i<b.length;i++){
            int end = clos(b,s,i);
            if(end == -1)
                break;
            if(bS == -1 || end - i < bE-bS){
                bS = i;
                bE = end;
            }
        }
        r[0] = bS;
        r[1] = bE;
        
        return r;
    }
    int clos(int b[], int s[], int ind){
        int max = -1;
        for(int i=0;i<s.length;i++){
            int next = findNext(b, s[i], i);
            if(next == -1)
                return -1;
            max = Math.max(next, max);
        }
        return max;
    }
    int findNext(int b[], int ele, int ind){
        for(int i = ind;i<b.length;i++){
            if(b[i] == ele )
                return i;
        }
        return -1;
    }
    
    //Method 2: keeping track of the closure in the backward way
    int[] shortSub(int b[], int s[]){
        int[] cl = getClos(b,s);
        return shortest(cl);
    }
    int[] getClos(int b[], int s[]){
        int cl[] = new int[b.length];
        for(int i = 0;i<s.length;i++){
            lookClos(b, cl, s[i]);
        }
        return cl;
    }
    void lookClos(int b[], int cl[], int val){
        int next = -1;
        for(int i = b.length-1;i>=0;i++){
            if(b[i] == val){
                next = i;
            }
            if((next==-1 || cl[i]<next) && cl[i] != -1)
                cl[i] = next;
        }
    }
    int[] shortest(int cl[]){
        int shortest = cl[1]-cl[0];
        int p[] = {cl[1],cl[0]};
        for(int i=2; i+1<cl.length;i+=2){
            int r = cl[i+1] - cl[i];
            if(r < shortest){
                p[0] = cl[i];
                p[1] = cl[i+1];
            }
        }
        return p;
    }
    public static void main(String[] args){}
}
