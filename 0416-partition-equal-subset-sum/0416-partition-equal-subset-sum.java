class Solution {
    public boolean solve(int[] nums,int i,int sum,int[][] dp){
        if(sum==0) return true;
        if(i==0) return nums[0]==sum;
        if(dp[i][sum]!=-1) return dp[i][sum]==1;
        boolean nopick=solve(nums,i-1,sum,dp);
        boolean pick=false;
        if(sum>=nums[i]) pick=solve(nums,i-1,sum-nums[i],dp);
        dp[i][sum]=(pick||nopick)?1:0;
        return pick||nopick;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
       
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
         int[][] dp=new int[n][sum/2+1];
         for(int[] row:dp){
            Arrays.fill(row,-1);
         }
        
        return solve(nums,n-1,sum/2,dp);
    }
}