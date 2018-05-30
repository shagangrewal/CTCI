package chapter10;
//implement a data structure and algorithm to keep track of the rank of a number
//track()whenever each number is generated and rankOfNumber():return number of values <=
class RankNode{
    int left_size = 0;
    int data = 0;
    RankNode left, right;
    RankNode(int d){
        data = d;
    }
    
    void insert(int d){
        if(d<=data)
            if(left != null)
                left.insert(d);
            else{
                left = new RankNode(d);
                left_size++;
            }
        else{
            if(right!=null)
                right.insert(d);
            else
                right = new RankNode(d);
        }
    }
    int getRank(int d){
        if(d==data)
            return left_size;
        else if(d<data){
            if(left!=null)
                return left.getRank(d);
            else
                return -1;
        }
        else{
            int right_rank = right==null?-1:right.getRank(d);
            if(right_rank == -1)
                return -1;
            else
                return left_size+1+right_rank;
        }
    }
}
public class q10 {
    RankNode root;
    void track(int n){
        if(root==null)
            root = new RankNode(n);
        else
            root.insert(n);
    }
    int getRankOfNumber(int n){
        return root.getRank(n);
    }
    public static void main(String[] args){}
}
