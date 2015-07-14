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
	  public TreeNode buildTree(int[] inorder, int[] postorder) {
	        
	        if(postorder.length==0 || inorder.length==0){
	            return null;
	        } 
	        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
	        for(int i=0;i<inorder.length;i++){
	            map.put(inorder[i],i);
	        }
	        TreeNode root=new TreeNode(postorder[postorder.length-1]);
	        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map );
	    }
	    
	    static TreeNode helper(int[] postorder, int posL,int posR,int[] inorder,int inL,int inR,HashMap<Integer,Integer> map){
	        
	        if(posL>posR || inL>inR)  
	            return null;  
	        
	        TreeNode root=new TreeNode(postorder[posR]);
	        int index=map.get(root.val);
	                                // [     (index-inL)root]
	        root.left=helper(postorder, posL,posL+(index-inL)-1 ,inorder, inL,index-1,map ) ;       // true size of left tree = index-inL
	        root.right=helper(postorder,posR-(inR-index),posR-1,inorder,index+1,inR,map);
	        
	        return root; 
	        
	        
	    }
    
    
}
