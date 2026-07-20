class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row=new ArrayList<>(Collections.nCopies(m,0));
            ans.add(row);
        }
        k=k%(n*m);
        if(k==0){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    ans.get(i).set(j,grid[i][j]);
                }
            }
            return ans;
        }
        for(int l=0;l<k;l++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0&&j==0){
                        ans.get(i).set(j,grid[n-1][m-1]);
                    }
                    else if(j==0){
                        ans.get(i).set(j,grid[i-1][m-1]);
                    }
                    else{
                        ans.get(i).set(j,grid[i][j-1]);
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j]=ans.get(i).get(j);
                }
            }
        }
        return ans;
        
    }
}