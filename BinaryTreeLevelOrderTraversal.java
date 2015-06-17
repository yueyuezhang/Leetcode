import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> LevelOrder(TreeNode root){
		List<List<Integer>> result=new ArrayList <List<Integer>>();
		if (root==null) return result;
		ArrayList<TreeNode> parentLevel=new ArrayList<TreeNode>();
		ArrayList<Integer> parentVal=new ArrayList<Integer>();
		parentLevel.add(root);
		parentVal.add(root.val);
		result.add(parentVal);
		while(parentLevel.size()>0){
			ArrayList<TreeNode> curr=new ArrayList<TreeNode>();
			ArrayList<Integer> currVal=new ArrayList<Integer>();
			for (int i=0;i<parentLevel.size();i++){
				TreeNode node=parentLevel.get(i);
				if(node.left!=null){
					curr.add(node.left);
					currVal.add(node.left.val);
				}
				if(node.right!=null){
					curr.add(node.right);
					currVal.add(node.right.val);
				}
			}
			parentLevel=curr;
			parentVal=currVal;
			if(parentVal.size()>0) result.add(parentVal);
		}
		return result;
		
	}
	public static void printListOfList(List<List<Integer>> result){
		for (int i=0;i<result.size();i++){
			List<Integer> curr=result.get(i);
			for(int j=0;j<curr.size();j++){
				System.out.print('[');
				System.out.print(curr.get(j));
			}
			System.out.println(']');
		}
	}
	public static void main(String[] args){
		TreeNode root=new TreeNode(3);
		TreeNode l1=new TreeNode(9);
		root.left=l1;
		TreeNode r1=new TreeNode(20);
		root.right=r1;
		TreeNode l2=new TreeNode(15);
		TreeNode r2=new TreeNode(7);
		r1.left=l2;
		r1.right=r2;
		List<List<Integer>> result=LevelOrder(root);
		printListOfList(result);
		
	}
	
}
