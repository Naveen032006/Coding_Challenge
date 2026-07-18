class Solution {
    public int gcd(int a,int b){
        while(b>0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int n=nums.length;
        int maxi=nums[0];
        int mini=nums[n-1];
        for(int i=0;i<n;i++){
            maxi=Math.max(nums[i],maxi);
            mini=Math.min(nums[i],mini);
        }
        return gcd(maxi,mini);
    }
}