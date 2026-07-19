class Solution {
    int solve(int[] nums,int i,int[] dp){
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int nopick=solve(nums,i-1,dp);
        int pick= pick=nums[i]+solve(nums,i-2,dp);
        return dp[i]= Math.max(pick,nopick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int nopick=dp[i-1];
            int pick=nums[i];
            if(i>1) pick=nums[i]+dp[i-2];
            dp[i]=Math.max(pick,nopick);
        }
        return dp[n-1];
    }
}