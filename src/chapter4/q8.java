package chapter4;
//find the first common ancestor of any two nodes in the Binary Tree
//need not to be a BST

public class q8 {
    TNode root;
    TNode commonAncestor(TNode root, TNode a, TNode b){
        if(root==null)
            return null;
        if(!isPresent(root, a) || !isPresent(root, b))
            return null;
        if(root == a || root == b)
            return root;
        return commonAncestor2(root, a, b);
    }
    TNode commonAncestor2(TNode root, TNode a, TNode b){
        if(root == null)
            return null;
        
        boolean aOnLeft = isPresent(root.left, a);
        boolean bOnLeft = isPresent(root.left, b);
        if(aOnLeft != bOnLeft)
            return root;
        TNode child = aOnLeft ? root.left : root.right;
        return commonAncestor2(child, a, b);
    }
    boolean isPresent(TNode root, TNode p){
        if(root == null)
            return false;
        if(root == p)
            return true;
        return isPresent(root.left, p) || isPresent(root.right, p); 
    }
    //Method-2: find the path up and check where they intersect
    //if they intersect at common node that will be the common ancestor
    //take two nodes, find their depth, move them up to the same level
    //keep uptracking while they are equa;, return the node when they both become equal;
    
    
    public static void main(String[] args){}
}
