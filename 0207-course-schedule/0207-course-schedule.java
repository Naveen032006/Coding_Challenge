class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int m=pre.length;
        int[] indegree=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        for(int i=0;i<n;i++){
            for(int node:adj.get(i)){
                indegree[node]++;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            } 
        }
        
        while(!q.isEmpty()){
            int node=q.poll();
            for(int adjnode:adj.get(node)){
                indegree[adjnode]--;
                if(indegree[adjnode]==0){
                    q.add(adjnode);
                    count++;
                }
            }
        }
        System.out.println(count);
        return count==n;

    }
}