package queen;

/**
 * This class arranges the queens on n*n matrix.
 * @author Martand
 *
 */
public class Queen {

	/**
	 *This function checks whether n queens can be placed on n*n board or not.
	 * @param chessBoard as a 2D Matrix of Chess Board
	 * @param col  as starting index for placing the queen.
	 * @param boardSize as a dimension of matrix.
	 * @return true if all queens are placed correctly.
	 */
	public static boolean nQueenSolution(int[][] chessBoard, int col, int boardSize){
		if( col >= boardSize ){
			for(int i =0; i < boardSize; i++){
				for(int j =0; j<boardSize;j++){
					System.out.print(" " + chessBoard[j][i] +" ");
				}
				System.out.print("\n");
			}
			return true;
		}
		for( int row=0; row<boardSize; row++ ){
			if( isSafe(chessBoard, row, col, boardSize) ){
				chessBoard[row][col]=1;
				if( nQueenSolution(chessBoard, col+1, boardSize) )
					return true;
				chessBoard[row][col]=0;
			}
		}
		return false;
	}


	/**
	 *This Function checks whether give pair of [row,col] id safe to place a queen.
	 * @param chessBoard as a 2D Matrix of Chess Board.
	 * @param row as a current row.
	 * @param col as a current column.
	 * @param boardSize as a dimension Of Board.
	 * @return true if current location is safe.
	 */
	private static boolean isSafe(int[][] chessBoard, int row, int col, int boardSize){
		int index;
		for( index=0; index<boardSize; index++){
			if( chessBoard[index][col]==1 || chessBoard[row][index]==1 ){
				return false;
			}
		}

		for( int rowIndex=0; rowIndex<boardSize; rowIndex++){
			for( int columnIndexj=0; columnIndexj<boardSize; columnIndexj++ ){
				if( rowIndex-columnIndexj == row-col || rowIndex+columnIndexj == row + col ){
					if( chessBoard[rowIndex][columnIndexj]==1 ){
						return false;
					}
				}
			}
		}
		return true;
	}

}
