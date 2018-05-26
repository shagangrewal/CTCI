package chapter4;
//find the next-node(in-order successor) of the given node in BST

public class q6 {
    TNode successor(TNode a){
        if(a==null)
            return null;
        if(a.right != null){
            return leftMostChild(a.right);
        }
        else{
            return rightMostChild(a.left);
        }
    }
    TNode rightMostChild(TNode a){
        if(a==null)
            return null;
        while(a.right != null){
            a = a.right;
        }
        return a;
    }
    TNode leftMostChild(TNode a){
        if(a==null)
            return null;
        while(a.left != null)
            a = a.left;
        return a;
    }
    public static void main(String[] args){}
}
