package chapter4;
//check if the binary tree is a binary search tree

public class q5 {
    static boolean isBST(TNode q){
        if(q==null)
            return true;
        if(q.left != null && q.left.data>q.data ){
            return false;
        }
        if(q.right != null && q.right.data < q.data){
            return false;
        }
        
        if(!isBST(q.left))
            return false;
        if(!isBST(q.right))
            return false;
        return true;
    }
    
    public static void main(String[] args){
        TNode a = new TNode(10);
        TNode b = new TNode(6);
        TNode c = new TNode(14);
        a.left = b;
        a.right = c;
        TNode d = new TNode(4);
        TNode e = new TNode(8);
        b.left = d;
        b.right = e;
        TNode h = new TNode(2);
        d.left = h;
        TNode f = new TNode(12);
        TNode g = new TNode(18);
        c.left = f;
        c.right = g;
        TNode j = new TNode(16);
        TNode k = new TNode(20);
        g.left = j;
        g.right = k;
        System.out.println(isBST(a));
    }
}
