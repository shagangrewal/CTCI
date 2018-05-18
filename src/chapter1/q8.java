package chapter1;
//replacing the whole row and whole column by '0' whenever there is a '0' encountered

public class q8 {
    public static void print(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void modify(int a[][]){
        boolean row[] = new boolean[a.length];
        boolean col[] = new boolean[a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<a.length;i++){
            if(row[i])
                zeroR(a,i);;
        }
        for(int i=0;i<a[0].length;i++){
            if(col[i])
                zeroC(a,i);;
        }
    }
    public static void zeroR(int a[][],int k){
        for(int i=0;i<a[0].length;i++){
            a[k][i] = 0;
        }
    }
    public static void zeroC(int a[][], int k){
        for(int i=0;i<a.length;i++){
            a[i][k] = 0;
        }
    }
    public static void Method2(int a[][]){
        boolean rowZero = false;
        boolean colZero = false;
        //check first row and first col if there is any zero
        for(int i=0;i<a.length;i++){
            if(a[i][0]==0)
                colZero = true;
                break;
        }
        
        for(int i=0;i<a[0].length;i++){
            if(a[0][i]==0)
                rowZero = true;
                break;
        }
        
        for(int i =1;i<a.length;i++){
            for(int j=1;j<a[0].length;j++){
                if(a[i][j]==0){
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
        
        for(int i=1;i<a.length;i++){
            if(a[i][0]==0)
                zeroR(a,i);
        }
        for(int i=1;i<a[0].length;i++){
            if(a[0][i]==0)
                zeroC(a,i);
        }
        if(rowZero){
            zeroR(a,0);
        }
        if(colZero){
            zeroC(a,0);
        }
    }
    public static void main(String[] agrs){
        int a[][] = {{1,2,3},{4,0,3},{8,2,4},{9,2,5}};
        System.out.println("Initial Matrix");
        print(a);
        //modify(a);
        //System.out.println("Final Matrix");
        //print(a);
        Method2(a);
        System.out.println("Final Matrix");
        print(a);
    }
}
