public class MaxDepth {
	int maxDep=0;
	public int maxDepth(TreeNode root){
		if (root==null) return 0;
		helper(root,0);
		return maxDep;
	}
	public void helper(TreeNode node,int depth){
		if(node==null) return;
		depth++;
		if(node.left==null &&node.right==null &&depth>maxDep) maxDep=depth;
		if(node.left!=null) helper(node.left,depth);
		if(node.right!=null) helper(node.right,depth);
	}
}
