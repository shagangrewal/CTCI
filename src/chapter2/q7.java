package chapter2;
import java.util.HashSet;
//given two singly linked list, check if the two intersect at any node
//by intersection it refers to a common node, that they had point to a common node
//return the intersecting node

public class q7 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    static boolean isInter(Node t1, Node d2){
        while(t1.next != null){
            t1 = t1.next;
        }
        while(d2.next != null){
            d2 = d2.next;
        }
        if(t1==d2)
            return true;
        else
            return false;
    }
    static boolean m2(Node t1, Node d2){
        HashSet<Node> h = new HashSet<Node>();
        while(t1 != null){
            t1 = t1.next;
            h.add(t1);
        }
        while(d2 != null){
            if(h.contains(d2)){
                return true;
            }
            d2 = d2.next;
        }
        return false;
    }
    
    public static void main(String[] args){
        Node t1 = new Node(3);
        Node t2  =new Node(1);
        t1.next = t2;
        Node t3 = new Node(5);
        t2.next = t3;
        Node t4 = new Node(9);
        t3.next = t4;
        Node t5 = new Node(7);
        t4.next = t5;
        Node t6 = new Node(2);
        t5.next = t6;
        Node t7 = new Node(1);
        t6.next = t7;
        Node d1 = new Node (4);
        Node d2 = new Node(6);
        d1.next = d2;
        d2.next = t5;
        System.out.println(isInter(t1,d2));
        System.out.println(m2(t1,d2));
    }
}
