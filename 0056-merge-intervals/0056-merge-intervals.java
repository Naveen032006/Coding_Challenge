class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        ArrayList<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            if(!ans.isEmpty()&&ans.get(ans.size()-1)[1]>=intervals[i][0]){
                ans.get(ans.size()-1)[1]=Math.max(intervals[i][1],ans.get(ans.size()-1)[1]);
            }
            else{
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}