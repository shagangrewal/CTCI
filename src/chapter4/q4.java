package chapter4;
//check if the binary tree is a balanced tree or not(i.e max diff between levels of subtrees is 1 at any node)

public class q4 {
    static int level(TNode a){
        if(a==null)
            return -1;
        return Math.max(level(a.left), level(a.right))+1;
    }
    static boolean isBalance(TNode a){
        if(a==null)
            return true;
        int height = level(a.left)-level(a.right);
        if(Math.abs(height)>1)
            return false;
        else{
            return isBalance(a.left) && isBalance(a.right);
        }
    }
    public static void main(String[] args){}
}
