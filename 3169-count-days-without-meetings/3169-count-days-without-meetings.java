class Solution {
    public int countDays(int days, int[][] meetings) {
        int n=meetings.length;
        ArrayList<int[]> ans=new ArrayList<>();
        Arrays.sort(meetings,(a,b)-> Integer.compare(a[0],b[0]));
        int count=0;
        int start=meetings[0][0];
        int end=meetings[0][1];
        count+=start-1;
        for(int i=1;i<n;i++){
            if(meetings[i][0]<=end){
                end=Math.max(end,meetings[i][1]);
            }
            else{
                count+=meetings[i][0]-end-1;
                start=meetings[i][0];
                end=meetings[i][1];
            }
        }
        count+=days-end;
        return count;
    }
}