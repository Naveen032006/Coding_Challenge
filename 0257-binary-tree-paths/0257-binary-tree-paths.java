/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> ans=new ArrayList<>();
    public void dfs(TreeNode root,StringBuilder fol){
        if(root==null) return;
        int len=fol.length();
        if(len!=0) fol.append("->");
        fol.append(root.val);
        if(root.left==null&&root.right==null) ans.add(fol.toString());
        else{
            dfs(root.left,fol);
            dfs(root.right,fol);
        }
        fol.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder st=new StringBuilder();
        dfs(root,st);
        return ans;
    }
}