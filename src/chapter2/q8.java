package chapter2;
import java.util.HashSet;
//return the node, which is at the beginning of the circular-loop

public class q8 {
    static Node head;
    static class Node{
        char data;
        Node next;
        Node(char k){
            data = k;
            next = null;
        }
    }
    static void out(){
        Node n = head;
        HashSet<Character> h = new HashSet<Character>();
        boolean a = true;
        while(a){
            if(h.contains(n.data)){
                a = false;
                System.out.println(n.data+" is the node at beginning of the loop");
            }
            else{
                h.add(n.data);
            }
            n = n.next;
        }
    }
    //using the fast runner and slow runner approach
    static char m2(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }
        
        if(fast==null || fast.next==null)
            return 'n';
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast.data;
    }
    public static void main(String[] args){
        q8 l = new q8();
        l.head = new Node('A');
        Node b = new Node('B');
        head.next = b;
        Node c = new Node('C');
        b.next = c;
        Node d = new Node('D');
        c.next  = d;
        Node e = new Node('E');
        d.next = e;
        e.next = b;
        out();
        System.out.println(m2());
    }
}
