package chapter16;
import java.util.*;
//design and build, "last recently used cache", evicting most recently used cache
//chache should map keys to values(allowing inserting and retrieving)
//if full, evict least recently used

//Eviction is removing the least recently used element on reaching the capacity

class Cache{
    private int maxCacheSize;
    //key is used for hashmap, easily store and lookup values
    private HashMap<Integer, LinkedListNode> hm = new HashMap<Integer, LinkedListNode>();
    LinkedListNode head = null;
    LinkedListNode tail = null;
    
    Cache(int max){
        maxCacheSize = max;
    }
    
    String getVal(int k){
        LinkedListNode item = hm.get(k);
        if(item == null)
            return null;
        
        if(item != head){
            removeFromList(item);
            insertAtFront(item);
        }
        return item.value;
    }
    
    void removeFromList(LinkedListNode a){
        if(a==null)
            return;
        
        if(a.prev != null)
            a.prev.next  = a.next;
        if(a.next != null)
            a.next.prev = a.prev;
        if(a == tail)
            tail = a.prev;
        if(a == head)
            head = a.next;
    }
    
    void insertAtFront(LinkedListNode a){
        if(head == null){
            head = a;
            tail = a;
        }
        else{
            head.prev = a;
            a.next = head;
            head = a;
        }
    }
    
    boolean removeKey(int k){
        LinkedListNode a = hm.get(k);
        removeFromList(a);
        hm.remove(k);
        return true;
    }
    
    void setKeyVal(int k, String val){
        removeKey(k);//if it already exists
        
        if(hm.size()>=maxCacheSize && tail != null)
            removeKey(tail.key);
        
        LinkedListNode a = new LinkedListNode(k, val);
        insertAtFront(a);
        hm.put(k, a);
    }
}
class LinkedListNode{
    LinkedListNode next, prev;
    int key;
    String value;
    LinkedListNode(int a, String b){
        this.key = a;
        this.value = b;
    }
}

public class q25 {
    public static void main(String[] args){}
}
