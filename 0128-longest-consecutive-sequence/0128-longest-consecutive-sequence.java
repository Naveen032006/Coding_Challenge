class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int maxcount=0;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        
        for(int num:set){
            if(!set.contains(num-1)){
                int start=num;
                int count=1;
                while(set.contains(start+1)){
                    count++;
                    start++;
                }
                maxcount=Math.max(maxcount,count);
            }
        }
        return maxcount;
    }
}