brute force:
    class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}
Optima answer:
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
