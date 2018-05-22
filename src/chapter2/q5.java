package chapter2;
//

public class q5 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    static void M1(Node l, Node l2){
        int total = 0;
        Node n1 = l;
        Node n2 = l2;
        int count = 0;
        while(n1!=null){
            total += n1.data*Math.pow(10, count)+ n2.data*Math.pow(10,count);
            n1 = n1.next;
            n2 = n2.next;
            count++;
        }
        System.out.println(total);
    }
    public static void main(String[] args){
        Node l = new Node(7);
        Node two = new Node(1);
        l.next = two;
        Node three = new Node(6);
        two.next = three;
        
        Node l2 = new Node(5);
        Node t2 = new Node(9);
        l2.next = t2;
        Node t3 = new Node(2);
        t2.next = t3;
        M1(l,l2);
    }
}
