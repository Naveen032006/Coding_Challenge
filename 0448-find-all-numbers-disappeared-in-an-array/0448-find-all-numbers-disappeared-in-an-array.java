class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int inx=Math.abs(nums[i])-1;
            if(nums[inx]>0){
                nums[inx]=-nums[inx];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}