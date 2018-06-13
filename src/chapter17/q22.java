package chapter17;
import java.util.*;
//given two words of equal length, in the dictionary, transform one into another by changing one letter at a time
//in doing so, the new word should also be in the dictionary as well

//designing two classes to aid the process
class PathNode{
    String word = null;
    PathNode previous =null;
    public PathNode(String w, PathNode p){
        this.word = w;
        this.previous = p;
    }
    
    String getWord(){
        return word;
    }
    
    //traverse nodes and return linkedlist
    LinkedList<String> collapse(boolean startRoot){
        LinkedList<String> path = new LinkedList<String>();
        PathNode node = this;
        while(node != null){
            if(startRoot)
                path.addLast(node.word);
            else
                path.addFirst(node.word);
            node = node.previous;
        }
        return path;
    }
}

class BFSData{
    Queue<PathNode> r = new LinkedList<PathNode>();
    HashMap<String, PathNode> visit = new HashMap<String, PathNode>();
    
    BFSData(String root){
        PathNode source = new PathNode(root, null);
        r.add(source);
        visit.put(root, source);
    }
    public boolean isFinished(){
        return r.isEmpty();
    }
}

public class q22 {
    //String[] words is the dictionary containing all the dictionary words
    
    //Method 1: basic brute force
    //for shortest oath we would choose breadth-first search mthod
    LinkedList<String> trans(String a, String b, String[] words){
        HashSet<String> dict = setDict(words);
        HashSet<String> vis = new HashSet<String>();
        return change(vis, a,b,dict);
    }
    LinkedList<String> change(HashSet<String> vis, String start, String end, HashSet<String> dic){
        if(start.equals(end)){
            LinkedList<String> path = new LinkedList<String>();
            path.add(start);
            return path;
        }
        else if(vis.contains(start) || !dic.contains(start)){
            return null;
        }
        
        vis.add(start);
        ArrayList<String> wrds = allWords(start);
        
        for(String ws : wrds){
            LinkedList<String> path = change(vis, ws, end, dic);
            if(path != null){
                path.addFirst(start);
                return path;
            }
        }
        
        return null;
    }
    HashSet<String> setDict(String[] words){
        HashSet<String> a = new HashSet<String>();
        for(String w : words){
            a.add(w.toLowerCase());
        }
        return a;
    }
    
    // trying all combinations by changing one letter at a time
    ArrayList<String> allWords(String w){
        ArrayList<String> ws = new ArrayList<String>();
        for(int i=0;i<w.length();i++){
            for(char j = 'a'; j<= 'z' ; j++){
                String a = w.substring(0,i) + j + w.substring(i+1);
                ws.add(a);
            }
        }
        return ws;
    }
    
    
    //Method 2: optimized one
    LinkedList<String> trans2(String a, String b, String words[]){
        HashMap<String, String> wild = getWords(words);
        
        BFSData source = new BFSData(a);
        BFSData end = new BFSData(b);
        
        while(!source.isFinished() && !end.isFinished()){
            String coll = searchLevel(wild, source, end);
            
            if(coll != null){
                return merge(source, end, coll);
            }
            
            coll = searchLevel(wild, end, source);
            if(coll != null)
                return merge(source, end, coll);
        }
        return null;
    }
    
    String searchLevel(HashMap<String, String> wordList, BFSData prime, BFSData second){
        int count = prime.visit.size();
        
        for(int i=0;i<count;i++){
            PathNode path1 = prime.r.poll();
            String word = path1.getWord();
            
            if(second.visit.containsKey(word)){
                return path1.getWord();
            }
            
            ArrayList<String> val = getValid(word, wordList);
            for(String w: val){
                if(!prime.visit.containsKey(w)){
                    PathNode next = new PathNode(w, path1);
                    prime.visit.put(w, next);
                    prime.r.add(next);
                }
            }
        }
        return null;
    }
    
    LinkedList<String> merge(BFSData bfs1, BFSData bfs2, String connection){
        PathNode end1 = bfs1.visit.get(connection);
        PathNode end2 = bfs2.visit.get(connection);
        
        LinkedList<String> path1 = end1.collapse(false);
        LinkedList<String> path2 = end2.collapse(true);
        
        path2.removeFirst();
        path1.addAll(path2);
        
        return path1;
    }
    
    ArrayList<String> getValid(String w, HashMap<String, String> b){
        ArrayList<String> a = getRoots(w);
        ArrayList<String> linked = getRoots(w);
        
        for(String ws : a){
          //  ArrayList<String> words = b.get(ws);
            //for(String link : words){
                //if(!link.equals(ws))
                    //linked.add(link);
        //}
            
        }
        
        return linked;
    }
    
    HashMap<String, String> getWords(String[] ws){
        HashMap<String, String> words = new HashMap<String, String>();
        for(String w: ws){
            ArrayList<String> link = getRoots(w);
            for(String l : link){
                words.put(l, w);
            }
        }
        
        return words;
    }
    
    ArrayList<String> getRoots(String w){
        ArrayList<String> a = new ArrayList<String>();
        for(int i=0;i<w.length();i++){
            String s = w.substring(0,i) +"_"+w.substring(i+1);
            a.add(s);
        }
        return a;
    }
    public static void main(String[] args){}
}
