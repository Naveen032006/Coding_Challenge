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
            Arrays.fill(row,0);
         }
         for(int i=0;i<n;i++){
            dp[i][0]=1;
         }
        if(nums[0]<=sum/2)dp[0][nums[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=sum/2;j++){
                 int nopick=dp[i-1][j];
                  int pick=0;
                  if(j>=nums[i]) pick=dp[i-1][j-nums[i]];
                  dp[i][j]=Math.max(pick,nopick);
            }
        }
        

        return dp[n-1][sum/2]==1;
    }
}