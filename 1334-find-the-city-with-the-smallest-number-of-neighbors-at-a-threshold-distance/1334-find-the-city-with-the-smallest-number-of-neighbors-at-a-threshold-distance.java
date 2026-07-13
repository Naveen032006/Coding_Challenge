class Solution {
    class pair{
        int node;
        int dis;
        public pair(int n,int d){
            this.node=n;
            this.dis=d;
        }
    }
    public int[] djk(ArrayList<ArrayList<pair>> adj,int src,int n){
        int[] reach=new int[n];
        Arrays.fill(reach,Integer.MAX_VALUE);
         PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.dis-b.dis;
        });
        pq.add(new pair(src,0));
        reach[src]=0;
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int node=curr.node;
            int dis=curr.dis;
             if(dis>reach[node]) continue;
            for(pair it:adj.get(node)){
               
                if(dis+it.dis<reach[it.node]){
                    reach[it.node]=dis+it.dis;
                    pq.add(new pair(it.node,dis+it.dis));
                }
            }
        }
        return reach;

    }
    public int findTheCity(int n, int[][] edges, int th) {
        int k=edges.length;
        int m=edges[0].length;
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<k;i++){
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
        }
        int ans=-1;
        int mincount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int[] disarr=djk(adj,i,n);
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j&&disarr[j]!=Integer.MAX_VALUE&&disarr[j]<=th){
                    count++;
                }
            }
            if(count<=mincount){
                ans=i;
                mincount=count;
            }
        }
        return ans;
        
    }
}