package chapter17;
import java.util.*;
//we have multiple documents, which are believed to be sparse, that is similarity similar to be 0
//design algo that list of documents along with their similarity
//similarity = (intersection of documents)/(union of two documents)
//print the documents and similarity only if the similarity is greater than 0

class DocPair{
    int doc1, doc2;
    
    DocPair(int d1, int d2){
        this.doc1 = d1;
        this.doc2 = d2;
    }
    
    public boolean equals(Object o){
        if(o instanceof DocPair){
            DocPair p = (DocPair) o;
            return p.doc1 == doc1 && p.doc2 == doc2;
        }
        return false;
    }
    
    public int hashCode(){
        return (doc1*31)^doc2;
    }
}

class Document{
    ArrayList<Integer> words;
    int docID;
    
    Document(int Id, ArrayList<Integer> a){
        this.docID  = Id;
        this.words = a;
    }
    
    ArrayList<Integer> getWords(){
        return words;
    }
    
    int getID(){
        return docID;
    }
    
    int size(){
        return words == null? 0: words.size();
    }
}

abstract class Element implements Comparable<Element>{
    int word, doc;
    
    public Element(int a, int b){
        this.word = a;
        this.doc = b;
    }
    
    public int compareTo(Element e){
        if(word == e.word)
            return doc - e.doc;
        return word - e.doc;
    }
}

public class q26 {
    HashMap<DocPair, Double> getSimilar(ArrayList<Document> docs){
        HashMap<DocPair, Double> similar = new HashMap<DocPair, Double>();
        for(int i=0;i<docs.size()-1;i++){
            for(int j=i+1;j<docs.size();j++){
                Document d1 = docs.get(i);
                Document d2 = docs.get(j);
                double sim = getSimilarity(d1,d2);
                if(sim>0){
                    DocPair p = new DocPair(d1.getID(),d2.getID());
                    similar.put(p, sim);
                }
            }
        }
        return similar;
    }
    
    Double getSimilarity(Document doc1, Document doc2){
        double similarity = 0;
        HashSet<Integer> set1 = new HashSet<Integer>();
        set1.addAll(doc1.getWords());
        
        for(int i : doc2.getWords()){
            if(set1.contains(i))
                similarity++;
        }
        
        double union = doc1.size() + doc2.size() - similarity;
        return similarity/union;
    }
    
    //Method 2: more optimized
    //1.built hashtables for list of documents
    //2. new hashmap pairing ddoucument pair to integer
    //3. read first hashtable by iterating though each list of documents
    //4. for each pair iterate through the pairs in list, increment intersection fpr each pair
    //HashMap<DocPair, Double> getSim2(HashMap<Integer, Document> documents){
      //  HashMap<Integer, Integer> words = new HashMap<Integer, Integer>();
    //}
    //HashMap<Integer, Integer> createPairs(HashMap<Integer, Document> docs){
    
    //}
    //HashMap<DocPair, Double> getInter(HashMap<Integer, Integer> wordDocs){
        
    //}
    void increment(HashMap<DocPair, Double> similar, int doc1, int doc2){
    
    }
    void adjustSimilar(HashMap<Integer, Document> docs, HashMap<DocPair, Double> similar){
    
    }
    
    //Method 3; optimized alternate method
    HashMap<DocPair, Double> sim3(HashMap<Integer, Document> docs){
        ArrayList<Element> ele = sortWords(docs);
        HashMap<DocPair, Double> similar = intersect(ele);
        getSimi(docs, similar);
        return similar;
    }
    ArrayList<Element> sortWords(HashMap<Integer, Document> docs){
        ArrayList<Element> ele = new ArrayList<Element>();
        
        for(Document doc : docs.values()){
            ArrayList<Integer> words = doc.getWords();
            for(int w : words){
                ele.add(new Element(w, doc.getID()){});
            }
        }
        
        return ele;
    }
    HashMap<DocPair, Double> intersect(ArrayList<Element> a){
        HashMap<DocPair, Double> sim = new HashMap<DocPair, Double>();
        
        for(int i=0;i<a.size();i++){
            Element l = a.get(i);
            for(int j=i+1;j<a.size();j++){
                Element r = a.get(j);
                if(l.word != r.word)
                    break;
                inc(sim,l.doc,r.doc);
            }
        }
        
        return sim;
    }
    
    //entring and incrementing the entries in the hashmap
    void inc(HashMap<DocPair, Double> similar, int doc1, int doc2){
        DocPair pair = new DocPair(doc1, doc2);
        if(!similar.containsKey(pair))
            similar.put(pair, 1.0);
        else
            similar.put(pair, similar.get(pair)+1.0);
    }
    void getSimi(HashMap<Integer, Document> docs, HashMap<DocPair, Double> sim){
        for(HashMap.Entry<DocPair, Double> entry  : sim.entrySet()){
            DocPair p = entry.getKey();
            Double common = entry.getValue();
            Document d1 = docs.get(p.doc1);
            Document d2 = docs.get(p.doc2);
            double union = (double)d1.size() + (double)d2.size() - common;
            entry.setValue(common/union);
        }
    }
    public static void main(String[] args){}
}
