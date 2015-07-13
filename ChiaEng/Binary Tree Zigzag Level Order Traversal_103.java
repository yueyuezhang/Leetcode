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

	 public  List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        
	        
	        List<List<Integer>> res= new ArrayList<List<Integer>>();
	        if(root==null) return res;
	        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
	        stack.push(root);
	        res.add(new ArrayList<Integer>());   
	        res.get(0).add(root.val);
	        helper(stack,res,0);
			return res;
	        
	        
	        
	    }
	    
	    static void helper(LinkedList<TreeNode> stack_h, List<List<Integer>> res_h,int layer){                             // bad naming
	        
	        
	        
	        LinkedList<TreeNode> stack_sub=new LinkedList<TreeNode>();
	        List<Integer> sublist=new ArrayList<Integer>();
	        
	        // 1. pop nodes
	        // 2. add children to list
	        // 3. push children to list
	        while(!stack_h.isEmpty()){                                                                                // Not using stack_h!=null
	            
	            

	            
	            TreeNode t=stack_h.pop();
	            if(layer%2==0){                                                                                     // should not make condition here.
	              if(t.right!=null){
	                TreeNode tr=t.right;  
	                sublist.add(tr.val);
	                stack_sub.push(tr);
	              }
	              if(t.left!=null){
	                TreeNode tl=t.left;  
	                sublist.add(tl.val);
	                stack_sub.push(tl);
	              }
	            }else{
	               if(t.left!=null){
	                TreeNode tl=t.left;  
	                sublist.add(tl.val);
	                stack_sub.push(tl);
	              }
	               if(t.right!=null){
	                TreeNode tr=t.right;  
	                sublist.add(tr.val);
	                stack_sub.push(tr);
	              }
	            }
	        }
	        
	        
	        if(stack_sub.isEmpty()) return;
	        res_h.add(new ArrayList<Integer>()); 
	        res_h.get(layer+1).addAll(sublist); 
	       // if(res_h.size()==){
        //         res_h.get(layer).addAll(sublist);
        //     }else{
        //         res_h.add(new ArrayList<Integer>(sublist));
        //     }
	        //res_h.add(sublist);
	        
	        helper(stack_sub,res_h,layer+1);
	    }
	
    
    
}
