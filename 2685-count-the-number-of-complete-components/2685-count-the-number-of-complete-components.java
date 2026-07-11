class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
    int m=edges.length;
    int[] vis=new int[n];
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
    }
    for(int i=0;i<m;i++){
        adj.get(edges[i][0]).add(edges[i][1]);
        adj.get(edges[i][1]).add(edges[i][0]);
    }
    int count=0;
     for(int i=0;i<n;i++){
        
        if(vis[i]!=1){
            Queue<Integer> q=new LinkedList<>();
            int ed=0;
            int ver=0;
            q.add(i);
            vis[i]=1;
            while(!q.isEmpty()){
                int node=q.poll();
                ver++;
                ed+=adj.get(node).size();
                for(int it:adj.get(node)){
                    if(vis[it]!=1){
                         q.add(it);
                         vis[it]=1;
                    } 
                }
            }
            if(ed==ver*(ver-1)) count++;
            
        }
     } 
     return count;  
    }
}