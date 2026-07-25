class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int lastsmall=Integer.MIN_VALUE;
        int count=1;
        int maxcount=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]-1==lastsmall){
                count++;
                lastsmall=nums[i];
            }
            else if(nums[i]!=lastsmall){
                count=1;
                lastsmall=nums[i];
            }
            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
    }
}