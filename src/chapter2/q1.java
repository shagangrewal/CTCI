package chapter2;
import java.util.HashSet;
//removing a duplicate element from an unsorted list
//case2: if temporary buffer is not allowed

public class q1 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    static void remDup(){
        HashSet<Integer> hs = new HashSet<Integer>();
        Node prev = null;
        Node n = head;
        while(n !=null){
            if(hs.contains(n.data)){
                prev.next = n.next;
            }
            else{
                hs.add(n.data);
                prev = n;
            }
            n = n.next;
        }
        printList();
    }
    static void printList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    static void Method2(){
        Node current = head;
        Node prev ;
        while(current != null){
            prev = current;
            while(prev.next != null){
                if(prev.next.data == current.data){
                    prev.next = prev.next.next;
                }
                else{
                    prev = prev.next;
                }
            }
            current = current.next;
        }
        printList();
    }
    public static void main(String[] args){
        q1 l = new q1();
        l.head = new Node(13);
        Node second = new Node(12);
        Node third = new Node(13);
        Node fourth = new Node(15);
        l.head.next = second;
        second.next = third;
        third.next  = fourth;
        //System.out.println("Method 1 with additional buffer:!!");
        //remDup();
        System.out.println("Method 2: if no additional buffer is allowed:");
        Method2();
    }
}
