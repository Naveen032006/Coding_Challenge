class Solution {
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] path){
        vis[i]=1;
        path[i]=1;
        for(int node:adj.get(i)){
            if(vis[node]!=1){
                if(dfs(node,adj,vis,path)) return true;
            }
            else if(path[node]==1) return true;
        }
        path[i]=0;
        return false;
        
    }
    public boolean canFinish(int n, int[][] pre) {
        int m =pre.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] vis=new int[n];
        int[] path=new int[n];
        for(int i=0;i<m;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                if(dfs(i,adj,vis,path)) return false;
            }
        }
        return true;
    }
}