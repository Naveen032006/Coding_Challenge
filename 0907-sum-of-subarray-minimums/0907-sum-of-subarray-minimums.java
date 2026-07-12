class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] nse=new int[n];
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        long sum=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            sum=sum+(long)left*right*arr[i];
            sum=sum%mod;

        }
        return (int)sum;
        
    }
}