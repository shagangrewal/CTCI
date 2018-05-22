package chapter2;
//implement algorithm to find kth to last element in a linked list
//easy if size is known, just iterate to (length - k)th element and print it

public class q2 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    static void printList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    static void M1(int k){
        //evalute the size and then iterate to (length-k)th element 
        Node n = head;
        int count = 0;
        while(n!=null){
            count++;
            n = n.next;
        }
        Node n2 = head;
        for(int i=0;i<count-k-1;i++){
            n2 = n2.next;
        }
        System.out.println(n2.data);
    }
    //using 2 pointers which are k elements apart
    static void M2(int k){
        Node n1 = head;
        Node n2 = head;
        for(int i=0;i<=k;i++){
            n1 = n1.next;
        }
        while(n1!=null){
            n1 = n1.next;
            n2 = n2.next;
        }
        System.out.println(n2.data);
    }
    public static void main(String[] args){
        q2 l = new q2();
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
        M1(2);
        M2(2);
    }
}
