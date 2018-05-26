package chapter4;
import java.util.*;
//for a given binary tree, design algorithm creating linked list for all nodes at smae depth in tree

public class q3 {
    static TNode root;
    
    public ArrayList<LinkedList<TNode>> createList(LinkedList<TNode> l){
        ArrayList<LinkedList<TNode>> result = new ArrayList<LinkedList<TNode>>();
        LinkedList<TNode> current = new LinkedList<TNode>();
        if(root != null)
            current.add(root);
        while(!current.isEmpty()){
            result.add(current);
            LinkedList<TNode> p = current;
            current = new LinkedList<TNode>();
            for(TNode u:p){
                if(u.left != null)
                    current.add(u.left);
                if(u.right != null)
                    current.add(u.right);
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        LinkedList<TNode> l = new LinkedList<TNode>();
    }
}
