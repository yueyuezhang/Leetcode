/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    
        if (nums.length==0){
            return null;
        }
        return helper(nums,0,nums.length-1);
        
    
    }
    
    TreeNode helper(int[] nums, int lBound, int rBound){
        
        if(lBound>rBound) return null;
        int m=0;
        if((lBound+rBound)%2==0){
            m=(lBound+rBound)/2;
        }else{
            m=1+(lBound+rBound)/2;
        }
        
        
        TreeNode root=new TreeNode(nums[m]);
        root.left=helper(nums,lBound,m-1);
        root.right=helper(nums,m+1,rBound);
        return root;
        
    }
}
