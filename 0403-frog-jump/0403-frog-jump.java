class Solution {
    public boolean solve(int[] arr,int i,int n,int k,Map<Integer,Integer> map,int[][]dp){
        if(i==n) return true;
        if(dp[i][k]!=-1) return dp[i][k]==1;
        for(int j=-1;j<=1;j++){
            int nextjump=k+j;
            if(nextjump<=0) continue;
            int nexpos=arr[i]+nextjump;
            if(map.containsKey(nexpos)){
                int nextstone=map.get(nexpos);
                if(solve(arr,nextstone,n,nextjump,map,dp)){
                    dp[i][k]=1;
                     return true;
                }
            }
        }
        dp[i][k]=0;
        return false;
    }
    public boolean canCross(int[] stones) {
        int n=stones.length;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(stones[i],i);
           
        }
        int[][] dp=new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(stones,0,n-1,0,map,dp);
    }
}