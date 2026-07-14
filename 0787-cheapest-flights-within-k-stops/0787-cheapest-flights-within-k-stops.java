class Solution {
    class pair{
        int node;
        int cost;
        int stop;
        public pair(int n,int c,int s){
            this.node=n;
            this.cost=c;
            this.stop=s;
        }
    }
    public int findCheapestPrice(int n, int[][] fl, int src, int dst, int k) {
        int l=fl.length;
        int m=fl[0].length;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<l;i++){
            adj.get(fl[i][0]).add(new int[]{fl[i][1],fl[i][2]});
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,0,0));
        while(!q.isEmpty()){
            pair curr=q.poll();
            int node=curr.node;
            int cost=curr.cost;
            int stop=curr.stop;
            if(stop>k) continue;
            for(int[] adjmat:adj.get(node)){
                int adjnode=adjmat[0];
                int edw=adjmat[1];
                if(cost+edw<dis[adjnode]){
                    dis[adjnode]=cost+edw;
                    q.add(new pair(adjnode,cost+edw,stop+1));
                }

            }
        }
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];

    }
}