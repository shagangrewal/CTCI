package chapter4;
import java.util.Random;
//create a fucntion called getRandomNode(), which returns a random node from the tree
class TreeNode{
    TreeNode root;
    private int data, size = 0;
    public TreeNode left, right;
    TreeNode(int k){
        data = k;
        size = 1;
    }
    TreeNode getRandomNode(){
        int leftSize = left==null ? 0 : left.size();
        Random r = new Random();
        int index = r.nextInt(size);
        if(index<leftSize)
            return left.getRandomNode();
        else if(index == leftSize)
            return root;
        else
            return right.getRandomNode();
    }
    void insertInOrder(int d){
        if(d <= data){
            if(left==null)
                left = new TreeNode(d);
            else
                left.insertInOrder(d);
        }
        else{
            if(right == null)
                right = new TreeNode(d);
            else
                right.insertInOrder(d);
        }
        size++;
    }
    int size(){
        return size;
    }
    int data(){
        return data;
    }
    TreeNode find(int d){
        if(d==data)
            return this;
        else if(d<=data)
            return left != null?left.find(d):null;
        else if(d > data)
            return right != null? right.find(d):null;
        else
            return null;
    }
}

//Method:2
class TN{
    TN root = null;
    int data, size=0;
    TN left, right;
    TN(int k){
        data = k;
        size = 1;
    }
    int size(){
        return root == null?0:root.size();
    }
    TN getRandomNode(){
        int leftSize = left==null?0:left.size;
        Random r = new Random();
        int index = r.nextInt(size());
        return getIthNode(index);
    }
    TN getIthNode(int q){
        int leftSize = left == null? 0 :left.size();
        if(q<leftSize)
            return left.getIthNode(q);
        else if(q==leftSize)
            return this;
        else
            return right.getIthNode(q-leftSize-1);
    }
}
public class q11 {
    
    public static void main(String[] args){}
}
