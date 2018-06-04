package chapter8;
import java.util.*;
// this problem is of tower ofhanoi
//n-disks 3 towers, only smaller disks can be placed on top of other disks
// move all disks from 1st tower to last using stacks
class tower{
        private Stack<Integer> s;
        private int index;
        public tower(int i){
            s = new Stack<Integer>();
            index = i;
        }
        int index(){
            return index;
        }
        void add(int d){
            if(!s.isEmpty() && s.peek() <= d){
                System.out.println("Can't place that disk:"+d);//if the next disk is bigger than the top
            }
            else
                s.push(d);
        }
        void moveTop(tower t){
            int top = s.pop();
            s.add(top);
        }
        void moveDisk(int n, tower dest, tower buffer){
            if(n>0){
                moveDisk(n-1, buffer, dest);
                moveTop(dest);
                buffer.moveDisk(n-1, dest, this);
            }
        }
    }

public class q6 {
    
    public static void main(String[] args){
        int n = 3;
        tower[] tow = new tower[n];
        for(int i=0;i<3;i++){
            tow[i] = new tower(i);
        }
        for(int i=n-1;i>=0;i--){
            tow[0].add(i);
        }
        tow[0].moveDisk(n, tow[2], tow[1]);
    }
}
