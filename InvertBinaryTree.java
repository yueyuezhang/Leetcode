public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root){
		if (root!=null){
			helper(root);
		}
		return root;
	}
	public void helper(TreeNode root){
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		if(root.left!=null){
			helper(root.left);
		}
		if(root.right!=null){
			helper(root.right);
		}
	}
}
