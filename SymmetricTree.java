public class SymmetricTree {
	public boolean isSymmetric(TreeNode root){
		if(root==null) return true;
		if(root.left!=null&&root.right==null) return false;
		if(root.right!=null&&root.left==null) return false;
		if(root.left==null && root.right==null) return true;
		return symmetricHelper(root.left,root.right);
	}
	public boolean symmetricHelper(TreeNode p,TreeNode q){
		if (p==null && q==null) return true;
		if (p==null && q!=null) return false;
		if (p!=null && q==null) return false;
		return symmetricHelper(p.left,q.right)&&symmetricHelper(p.right,q.left)&&(p.val==q.val);
	}
}
