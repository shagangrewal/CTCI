package chapter2;
import java.util.Stack;
//check if the linked list is palindrome or not

public class q6 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int k){
            data = k;
            next = null;
        }
    }
    //method-1 
    static boolean isPalindrome(){
        Node fast = head;
        Node slow = head;
        Stack<Integer> s = new Stack<Integer>();
        while(fast != null && fast.next != null){
            s.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        //to make sure if the list have odd number's
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){
            int temp = s.pop().intValue();
            if(slow.data != temp)
                return false;
            slow = slow.next;
        }
        return true;
    }
    //Method-2 using the recursive method
    static int len(){
        Node n = head;
        int size = 0;
        while(n!= null){
            size++;
            n = n.next;
        }
        return size;
    }
    static boolean isPalRecurse(int l){
        Node n = head;
        if(l==0 || head==null || l==1)
            return true;
        boolean a = isPalRecurse(l-2);
        return false;
    }
    public static void main(String[] args){
        q6 l = new q6();
        l.head = new Node(1);
        Node t1 = new Node(2);
        head.next = t1;
        Node t2 = new Node(3);
        t1.next = t2;
        Node t3 = new Node(4);
        t2.next = t3;
        Node t4 = new Node(4);
        t3.next = t4;
        Node t5 = new Node(2);
        t4.next = t5;
        Node t6 = new Node(1);
        t5.next = t6;
        System.out.println(isPalindrome());
    }
}
