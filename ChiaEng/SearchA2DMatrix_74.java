
public class SearchA2DMatrix_74 {

		
	public static void main(String args[]){
		
		int[][] matrix=new int[][]{
				{1},{3}
		};
		System.out.println(searchMatrix(matrix,0));
		
	}
	
	public static boolean searchMatrix(int[][]matrix, int target){
		
		if (matrix==null||matrix[0].length==0||matrix.length==0){								
		}
		
		int row=matrix.length;
		int col=matrix[0].length;
		
		int start=0;
		int end = (col*row)-1;				// start from zero

		while(start<end){
			int mid=(start+end)/2;
			int midRow=mid/col;				// divide (how length per row). Vertical dir
			int midCol=mid%col;			// look into non-full row (of element).  Horizontal dir
			
			if(target==matrix[midRow][midCol]){
				return true;
			}else if(target>matrix[midRow][midCol]){			// break to line again
				start=mid+1;
			}else{
				end=mid-1;
			}
		}
			
		return false;
		
	}

}
