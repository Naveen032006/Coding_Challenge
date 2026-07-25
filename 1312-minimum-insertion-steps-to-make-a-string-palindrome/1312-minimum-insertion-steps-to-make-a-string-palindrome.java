class Solution {
    public int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        int[] prev=new int[m+1];
        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
        }
        return prev[m];
    }
    public int minInsertions(String s) {
        int n=s.length();
        String s2=new StringBuilder(s).reverse().toString();
        int count=lcs(s,s2);
        return n-count;
    }
}