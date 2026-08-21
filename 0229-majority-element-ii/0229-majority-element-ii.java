class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int count1=0;
        int count2=0;
        int el1=-1;
        int el2=-2;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
           if(count1==0&&nums[i]!=el2){
                el1=nums[i];
                count1++;
           } 
           else if(count2==0&&nums[i]!=el1){
                el2=nums[i];
                count2++;
           }
           else if(nums[i]==el1) count1++;
           else if(nums[i]==el2) count2++;
           else{
            count1--;
            count2--;
           }
        }
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<n;i++){
            if(el1==nums[i]) cnt1++;
            if(el2==nums[i]) cnt2++;
        }
        if(cnt1>n/3) ans.add(el1);
        if(cnt2>n/3) ans.add(el2);
        return ans;
        

    }
}