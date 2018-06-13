package chapter17;
//given a square matrix, write code to find submatrix with largest possible sum

class SubMatrix{
    int row1, row2, col1, col2, sum;
    
    SubMatrix(int a, int b, int c, int d, int e){
        this.row1 = a;
        this.row2 = c;
        this.col1 = b;
        this.col2 = d;
        this.sum = e;
    }
    
    int getSum(){
        return sum;
    }
}

//this class will keep track of columns from starting to end
class Range{
    int start, end, sum;
    Range(int a, int b, int c){
        this.start = a;
        this.end = b;
        this.sum = c;
    }
}
public class q24 {
    //Brute Force method: this takes O(N^6)
    SubMatrix maxSum(int[][] a){
        int r1 = a.length;
        int c1 = a[0].length;
        int sum = 0;
        SubMatrix best = null;
        for(int i1 =0;i1<r1;i1++){
            for(int i2 = i1;i2<r1;i2++){
                for(int j1 = 0;j1<c1 ; j1++){
                    for(int j2 = j1;j2<c1;j2++){
                        int s = getS(a,i1,j1,i2,j2);
                        if(best == null || best.getSum()<s)
                            best = new SubMatrix(i1,j1,i2,j2,s);
                    }
                }
            }
        }
        return best;
    }
    int getS(int[][] m, int a,int b,int c,int d){
        int sum = 0;
        for(int i = a;i<=c;i++){
            for(int j= b; j<=d;j++){
                sum += m[i][j];
            }
        }
        return sum;
    }
    
    
    //even if we use dynammic programming, we will precompute the sub sums in a matrix 
    //which will reduce the complexity to O{N^4)
    
    
    //Method3 : optimized problem
    SubMatrix getMax(int[][] m){
        SubMatrix best = null;
        int rC = m.length;
        int cC = m[0].length;
        
        for(int i=0;i<rC;i++){
            int[] partialS = new int[cC];
            for(int j=i;j<rC;j++){
                for(int z=0;z<cC;z++){
                    partialS[z] = m[j][z];
                }
                Range bestR = maxSub(partialS,cC);
                
                if(best == null || best.getSum() < bestR.sum)
                    best = new SubMatrix(i,bestR.start,j,bestR.end,bestR.sum);
            }
        }
        
        return best;
    }
    
    Range maxSub(int m[], int n){
        Range best = null;
        int start = 0;
        int s = 0;
        
        for(int i=0;i<n;i++){
            s += m[i];
            if(best ==null || best.sum < s){
                best = new Range(start, i, s);
            }
            
            if(s < 0){
                s = 0;
                start = i+1;
            }
        }
        
        return best;
    }
    public static void main(String[] args){}
}
