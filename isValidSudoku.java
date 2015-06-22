public class ValidSudoku {
	public boolean isValidSudoku(char[][] board){
		for(int i=0;i<board.length;i++){
			int[] checker=new int[9];
			for(int k=0;k<9;k++){
				checker[k]=0;
			}
			for(int j=0;j<board[i].length;j++){
				if (board[i][j]!='.'){
					if(checker[Character.getNumericValue(board[i][j]-1)]==1) return false;
					else checker[Character.getNumericValue(board[i][j]-1)]=1;
				}
			}
		}
		for(int i=0;i<board[0].length;i++){
			int[] checker=new int[9];
			for(int k=0;k<9;k++){
				checker[k]=0;
			}
			for(int j=0;j<board.length;j++){
				if (board[j][i]!='.'){
					if(checker[Character.getNumericValue(board[j][i]-1)]==1) return false;
					else checker[Character.getNumericValue(board[j][i]-1)]=1;
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int[] checker=new int[9];
				for(int k=0;k<9;k++){
					checker[k]=0;
				}
				for(int a=0;a<3;a++){
					for(int b=0;b<3;b++){
						if (board[3*i+a][3*j+b]!='.'){
							if(checker[Character.getNumericValue(board[3*i+a][3*j+b]-1)]==1) return false;
							else checker[Character.getNumericValue(board[3*i+a][3*j+b]-1)]=1;
						}
					}
				}
			}
		}
		return true;
	}
}
