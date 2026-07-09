class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length;
        Stack<Integer> st=new Stack<>();
        int maxarea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&h[st.peek()]>h[i]){
                int el=st.peek();
                st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxarea=Math.max(maxarea,h[el]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int el=st.peek();
            st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            maxarea=Math.max(maxarea,h[el]*(nse-pse-1));
        }
        return maxarea;
        
    }
}