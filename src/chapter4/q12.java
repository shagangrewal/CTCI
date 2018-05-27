package chapter4;
//given a BST(containing positive and negative values),
//count the number of paths that lead to sum to a given value

public class q12 {
    TNode root;
    //Method:1 using the brute force method, resulting in O(N long N)
    int countPaths(TNode root, int sum){
        if(root == null)
            return 0;
        
        int pathsfromRoot = pathsFromRoot(root, sum,0);
        int pathsOnLeft = countPaths(root.left, sum);
        int pathsOnRight = countPaths(root.right, sum);
        
        return pathsOnLeft+ pathsOnRight+pathsfromRoot;
    }
    int pathsFromRoot(TNode a, int sum, int curSum){
        if(a==null)
            return 0;
        curSum += a.data ;
        int totalPaths = 0;
        if(curSum == sum)
            totalPaths++;
        totalPaths += pathsFromRoot(a.left, sum, curSum);
        totalPaths += pathsFromRoot(a.right, sum, curSum);
        
        return totalPaths;
    }
    public static void main(String[] args){}
}
