package chapter4;
import java.lang.*;
//given two binary trees T1 and T2, with T1 bigger in size than T2
//create an algorithm to check if T2 is subtree of T1

public class q10 {
    boolean subTree(TNode a, TNode b){
        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();
        
        orderTrav(t1, a);
        orderTrav(t2, b);
        
        return t1.indexOf(t2.toString()) != -1;
    }
    void orderTrav(StringBuilder s, TNode a){
        if(a==null){
            s.append("X");
        }
        
        s.append(a.data+"");
        orderTrav(s, a.left);
        orderTrav(s, a.right);
    }
    
    //Method: 2
    boolean subTree2(TNode a, TNode b){
        if(b==null)
            return true;
        return matchSub(a,b);
    }
    boolean matchSub(TNode a, TNode b){
        if(a==null)
            return false;
        else if(a.data==b.data && matchTree(a,b))
            return true;
        else 
            return matchTree(a,b);
    }
    boolean matchTree(TNode a, TNode b){
        if( a==null && b == null)
            return true;
        if(a==null || b==null)
            return false;
        if(a.data != b.data)
            return false;
        else
            return matchTree(a.left, b.left) || matchTree(a.right, b.right);
    }
    public static void main(String[] args){}
}
