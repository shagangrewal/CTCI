package chapter4;
//Given a sorted array(increasing order) with unique elements, create Binary Search tree with minimal Height

class TNode{
    int data;
    TNode right, left, parent;
    TNode(int k){
        data = k;
        right= null;
        left = null;
    }
}
public class q2 {
    TNode root;
    
    static TNode minBST(int a[], int start, int end){
        if(start<end)
            return null;
        int mid = (start+end)/2;
        TNode n = new TNode(a[mid]);
        n.left = minBST(a,start, mid-1);
        n.right = minBST(a,mid+1, end);
        return n;
    }
    public static void main(String[] args){
        int a[] = {};
    }
}
