class Solution {
    public void dopermutation(int[] nums,int index,List<List<Integer>> ans){
        if(index==nums.length){
            ArrayList<Integer> curr=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                curr.add(nums[i]);
            }
            ans.add(curr);
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            dopermutation(nums,index+1,ans);
            swap(nums,i,index);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        dopermutation(nums,0,ans);
        return ans;
    }
}