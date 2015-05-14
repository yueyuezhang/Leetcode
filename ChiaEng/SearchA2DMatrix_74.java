
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
		int end = (col*row)-1;									// start from zero

		while(start<=end){
			int mid=(start+end)/2;
			int midRow=mid/col;									// divide (how length per row). Vertical dir
			int midCol=mid%col;									// look into non-full row (of element).  Horizontal dir
			
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


/*
Thoughts:

1. Treat 2d array as a list. So the middle element equals (end+start)/2.
   Then transfer this middle number as coordinate for matrix:
   		row=mid/col
   		col=mid%col

2. do binary sort. each time narrow down the range of matrix by swap end and start with mid
   start=mid+1
   end=mid-1
   Don't forget +1 and -1	

3. While condition should contains "equal" 

Coding:

1. For testing, initialize 2d array:
	int[][] matrix=new int[][]{
				{1},{3}
		};

*/