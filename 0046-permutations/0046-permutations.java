class Solution {
    public void backtrack(int[] nums,int[] used,List<List<Integer>> ans,List<Integer> curr){
        if(nums.length==curr.size()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==1){
                continue;
            }
            used[i]=1;
            curr.add(nums[i]);
            backtrack(nums,used,ans,curr);
            curr.remove(curr.size()-1);
            used[i]=0;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        int[] used=new int[n];
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        backtrack(nums,used,ans,curr);
        return ans;
    }
}