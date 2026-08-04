Optimal Solution:
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            int count=0;
            for(int num:nums){
                if(num<=mid){
                    count++;
                }
            }
            if(count>mid){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return high;

    }
}
time Complexity:O(nlogn);
Space Complexity:O(1);

Brute Force:
    class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}
time Complexity:O(n);
Space Complexity:O(n);
