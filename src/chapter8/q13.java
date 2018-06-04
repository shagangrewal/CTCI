package chapter8;
import java.util.*;
//given n stacks of boxes, find max height placing one over the other
//the bottom stack should be bigger in (l,b,h) than the one on the top
//order should be followed till the no viable option is available

public class q13 {
    int createstack(ArrayList<Integer> box){
        Collections.sort(box);
        int maxH = 0;
        int stackMap[] = new int[box.size()];
        for(int i=0;i<box.size();i++){
            int height = createStack(box, i, stackMap);
            maxH = Math.max(maxH, height);
        }
        return maxH;
    }
    int createStack(ArrayList<Integer> box, int bottomIndex, int[] stackMap){
        if(bottomIndex < box.size() && stackMap[bottomIndex]>0)
            return stackMap[bottomIndex];
        
        int b = box.get(bottomIndex);
        int maxH = 0;
        for(int i=bottomIndex+1;i<box.size();i++){
            int height = createStack(box, bottomIndex, stackMap);
            maxH = Math.max(maxH, height);
        }
        return maxH;
    }
    
    //Method:2
    int createST(ArrayList<Integer> box){
        Collections.sort(box);
        int stackM[] = new int[box.size()];
        return maxHeight(box, 0, 0, stackM);
    }
    int maxHeight(ArrayList<Integer> box, int bottomIndex, int offset, int[] stackMap){
        if(offset>=box.size())
            return 0;
        int newB = box.get(offset);
        int heightB = 0;
        if(bottomIndex <0 || newB > bottomIndex){
            if(stackMap[offset]==0){
                stackMap[offset] = maxHeight(box, newB, offset+1, stackMap);
                //stackMap[offset] += newB.hegiht;
            }
            heightB = stackMap[offset];
        }
        int heightNB = maxHeight(box, bottomIndex, offset+1, stackMap);
        return Math.max(heightB, heightNB);
    }
    public static void main(String[] args){}
}
