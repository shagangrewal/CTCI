package chapter4;
import java.util.*;
//design an algorithm to find out if there is a route between two nodes, in directed graph

//return false if no route is found, else true
//using BFS(prefered)/DFS, visit nodes, we we find that particular node, return true
//otherwise mark it visited and move on to the next nodes

public class q1 {
    enum State{unvisited, visiting, visited;}
    public static State state;
    //boolean search(Graph g, Node a, Node b){
      //  if(a==b)
        //    return true;
        //LinkedList<Node> q = new LinkedList<Node>();
        //for(Node u: g.nodes){
          //  u.state = State.unvisited;
        //}
        //a.state = State.visited;
    //    q.add(a);
      //  Node u;
        //while(!q.isEmpty()){
          //  u = q.removeFirst();
            //if(u != null){
              //  for(Node v : u.getAdjacent()){
                //    if(v.state = State.unvisited){
                  //      if(v == b){
                    //        return true;
                      //  }
                        //else{
//                            v.state = State.visiting;
  //                          q.add(v);
    //                    }
      //              }
        //        }
          //  }
            //u.state = State.visited;
        //}
        //return false;
   // }
    
    
}
