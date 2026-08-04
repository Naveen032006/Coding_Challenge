class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        List<Integer> ans=new ArrayList<>();
        int top=0;
        int down=n-1;
        int left=0;
        int right=m-1;
        while(left<=right&&top<=down){
            for(int i=left;i<=right;i++){
                ans.add(mat[top][i]);
            }
            top++;
           
                for(int i=top;i<=down;i++){
                    ans.add(mat[i][right]);
                }
                right--;
            
            if(top<=down){
                for(int i=right;i>=left;i--){
                    ans.add(mat[down][i]);
                }
                down--;
            }
            if(left<=right){
                for(int i=down;i>=top;i--){
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}