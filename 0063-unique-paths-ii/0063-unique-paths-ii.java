class Solution {
    public int solve(int[][] arr,int i,int j,int[][] dp){
        if(i==0&&j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int top=0;
        if(i>0&&arr[i][j]!=1) top=solve(arr,i-1,j,dp);
        int left=0;
        if(j>0&&arr[i][j]!=1) left=solve(arr,i,j-1,dp);

        return dp[i][j]=left+top;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        if(arr[0][0]==1) return 0;
        if(arr[n-1][m-1]==1) return 0;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0&&arr[i][j]!=1){
                    dp[i][j]=1;
                    continue;
                }
                int top=0;
                if(i>0&&arr[i][j]!=1) top=dp[i-1][j];
                int left=0;
                if(j>0&&arr[i][j]!=1) left=dp[i][j-1];

                 dp[i][j]=left+top;
            }
        }
        return dp[n-1][m-1];
    }
}