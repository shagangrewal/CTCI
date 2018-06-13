package chapter17;
import java.util.*;
//given heights and weights of each person, create a circus tower
//such that each person should be lighter and shorter than the one standing below

class HtWt implements Comparable<HtWt>{
    int height, weight;
    
    HtWt(int a, int b){
        this.height = a;
        this.weight = b;
    }
    
    public int compareTo(HtWt sec){
        if(this.height != sec.height)
            return ((Integer)this.height).compareTo(sec.height);
        else
            return ((Integer)this.weight).compareTo(sec.weight);
    }
    
    boolean isBefore(HtWt other){
        if(this.height < other.height && this.weight < other.weight)
            return true;
        
        return false;
    }
}
public class q8 {
    //Method 1: through recursion
    ArrayList<HtWt> longIncSeq(ArrayList<HtWt> items){
        Collections.sort(items);
        return bestSeq(items, new ArrayList<HtWt>(), 0);
    }
    ArrayList<HtWt> bestSeq(ArrayList<HtWt> a, ArrayList<HtWt> seq, int ind){
        if(ind >= a.size())
            return seq;
        
        HtWt val = a.get(ind);
        ArrayList<HtWt> list = null;
        
        if(canAppend(seq, val)){
            ArrayList<HtWt> seqWith = (ArrayList<HtWt>) seq.clone();
            seqWith.add(val);
            list = bestSeq(a, seqWith, ind+1);
        }
        
        ArrayList<HtWt> bestWithout = bestSeq(a, seq, ind+1);
        
        if(list == null || bestWithout.size() > list.size())
            return bestWithout;
        else
            return list;
        
    }
    boolean canAppend(ArrayList<HtWt> list, HtWt o){
        if(list == null)
            return false;
        if(list.size()==0)
            return true;
        
        HtWt a = list.get(list.size()-1);
        return a.isBefore(o);
    }
    ArrayList<HtWt> max(ArrayList<HtWt> list1, ArrayList<HtWt> list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        
        return list1.size() > list2.size() ? list1 : list2;
    }
    
    
    //Method 2: this is an interative process
    ArrayList<HtWt> longSeq2(ArrayList<HtWt> a){
        Collections.sort(a);
        
        ArrayList<ArrayList<HtWt>> sol = new ArrayList<ArrayList<HtWt>>();
        ArrayList<HtWt> bestSeq = new ArrayList<HtWt>();
        
        for(int i=0;i<a.size();i++){
            
        }
        
        return bestSeq;
    }
    
    ArrayList<HtWt> bestSeqAtIdx(ArrayList<HtWt> a, ArrayList<ArrayList<HtWt>> sol, int idx){
        HtWt val = a.get(idx);
        
        ArrayList<HtWt> seq = new ArrayList<HtWt>();
        
        for(int i=0;i<idx;i++){
            ArrayList<HtWt> sols = sol.get(i);
            if(canAppend(sols, val))
                seq = max(seq, sols);
        }
        
        ArrayList<HtWt> best = (ArrayList<HtWt>) seq.clone();
        best.add(val);
        
        return seq;
    }
    public static void main(String[] args){}
}
