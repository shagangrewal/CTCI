package chapter2;
//delete the middle node, singly linked list, given access to only that node
//not necessarily the exact middle, but any apart from first and last
//given access to that particular node

public class q3 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    static void M1(Node k){
        if(k==null || k.next==null)
            System.out.println("First or the last Node");
        else{
            k.data = k.next.data;
            k.next = k.next.next;
        }
        Node n = head;
        while(n!=null){
            System.out.print(n.data+"  ");
            n = n.next;
        }
        System.out.println();
        
    }
    public static void main(String[] args){
        q3 l = new q3();
        l.head = new Node(1);
        Node sec = new Node(2);
        head.next = sec;
        Node third = new Node(3);
        sec.next = third;
        Node four = new Node(4);
        third.next = four;
        Node fiv = new Node(5);
        four.next = fiv;
        Node six = new Node(6);
        fiv.next = six;
        M1(sec);
    }
}
