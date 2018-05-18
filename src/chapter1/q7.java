package chapter1;
//rotating a N*N matrix by 90 degrees clockwise

public class q7 {
    public static void printM(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void rotate(int a[][]){
        for(int i=0;i<a.length/2;i++){
            int k = a.length - i -1;
            for(int j=i;j<k;j++){
                int m = j-i;
                int temp = a[i][j];//top-left
                a[i][j] = a[k-m][i]; //bottom-left to top-left
                a[k-m][i] = a[k][k-m]; //botthom-row to left-column
                a[k][k-m] = a[j][k]; //right-column to bottom-row
                a[j][k] = temp; //top-left to top-right       
            }
        }
    }
    public static void main(String[] args){
        int a[][] = {{0,1,2,3},{2,3,4,5},{4,5,6,7},{6,7,8,9}};
        System.out.println("Intial Matrix");
        printM(a);
        rotate(a);
        System.out.println("Rotated Matrix");
        printM(a);
    }
}
