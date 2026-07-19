class Solution {
    public int solve(int i,int[] dp){
        if(i==0) return 1;
        if(i==1) return 1;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=solve(i-1,dp)+solve(i-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        // dp[0]=1;
        // dp[1]=1;
        // for(int i=2;i<n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        return solve(n,dp);
    }
}