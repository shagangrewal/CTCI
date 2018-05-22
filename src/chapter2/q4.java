package chapter2;
//partition a list around a value x, smaller come before the larger or the equal to x

public class q4 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    static void M1(int x){
        Node beforeS = null;
        Node beforeE = null;
        Node afterS = null;
        Node afterE = null;
        
        Node n = head;
        while(n!=null){
            if(n.data < x){
                if(beforeS == null){
                    beforeS = n;
                    beforeE = beforeS;
                }
                else{
                    beforeS.next = n;
                    beforeE = n;
                }
            }
            else{
                if(afterS == null){
                    afterS = n;
                    afterE = afterS;
                }
                else{
                    afterS.next = n;
                    afterE = n;
                }
            }
            n = n.next;
        }
        beforeE.next = afterS;
    }
    static void M2(int x){
        Node h1 = null;
        Node tail = null;
        Node n = head;
        while(n != null){
            if(n.data < x){
                n.next = h1;
                h1 = n;
            }
            else{
                tail.next = n;
                tail = n;
            }
            n = n.next;
        }
    }
    static void M3(int x){
        Node a = head;
        Node count2 = head.next; //keeps track of the values less than a;
        if(a.data>x && count2.data<x){
            int temp = count2.data;
            count2.data = a.data;
            a.data = temp;
            a = count2;
        }
        if(a.data>x && count2.data >= x){
            Node b  = count2.next;
            while(a.data>x){
                if(b.data<x){
                    int temp = b.data;
                    b.data = a.data;
                    a.data = temp;
                    a = a.next;
                    break;
                }
                b = b.next;
            }
        }
        while(a != null){
            if(a.data<x && a!=head ){
                int temp = count2.data;
                count2.data = a.data;
                a.data = temp;
                count2 = count2.next;
            }
            a = a.next;
        }
        Node n = head;
        while(n!=null){
            System.out.print(n.data+ "  ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        q4 l = new q4();
        l.head = new Node(6);
        Node sec = new Node(5);
        head.next = sec;
        Node third = new Node(8);
        sec.next = third;
        Node four = new Node(5);
        third.next = four;
        Node fiv = new Node(10);
        four.next = fiv;
        Node six = new Node(2);
        fiv.next = six;
        Node sev = new Node(1);
        six.next = sev;
        Node eight = new Node (6);
        sev.next = eight;
        Node nine = new Node(4);
        eight.next = nine;
       // M1(5);
       // M2(5);
        M3(5);
    }
}
