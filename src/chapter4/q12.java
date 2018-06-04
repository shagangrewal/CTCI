package chapter4;
import java.util.*;
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
    
    //Method 2: optimized method to do so
    int countPathswithSum(TNode root, int sum){
        return countPathSum(root, sum, 0, new HashMap<Integer, Integer>());
    }
    int countPathSum(TNode node, int targetSum,int runningSum,HashMap<Integer,Integer> pathCount){
        if(node == null)
            return 0;
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        if(runningSum == targetSum)
            totalPaths++;
        incrementHashMap(pathCount, runningSum, 1);
        totalPaths += countPathSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathSum(node.right, targetSum, runningSum, pathCount);
        incrementHashMap(pathCount, runningSum,-1);
        
        return totalPaths;
    }
    void incrementHashMap(HashMap<Integer, Integer> hmap, int key, int delta){
        if(delta==0)
            hmap.remove(key);
        else{
            hmap.put(key, delta);
        }
    }
    public static void main(String[] args){}
}
