class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        while(!pq.isEmpty()&&k-1>0){
            pq.poll();
            k--;
        }
        return pq.isEmpty()?-1:pq.peek();

    }
}