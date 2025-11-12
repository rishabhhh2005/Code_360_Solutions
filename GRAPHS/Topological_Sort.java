// https://practice.geeksforgeeks.org/problems/topological-sort/1
import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        //first we will create adj
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> a :edges){
            int u = a.get(0);
            int w = a.get(1);
            adj.get(u).add(w);
        }
        //topo sort on adj with BFS(kahn's algorithm)
        
        int[] indegree = new int[v];
        Queue<Integer> q = new LinkedList<>();
        
        //first we will calculate indegree of every node
  
        for(int i=0;i<adj.size();i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }
        
        //find the node with 0 degree
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int node : adj.get(curr)){
                indegree[node]--;
                if(indegree[node] == 0) q.offer(node);
            }
            res.add(curr);
            
        }
        return res;


    }
}
