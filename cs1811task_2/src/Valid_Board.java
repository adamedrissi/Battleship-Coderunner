public class Valid_Board { // ignore
	
	public static Boolean boardSquare(char valid) {	//	1.1 Valid Board Method (Boolean)
		if (valid != '.' && valid != 'S' && valid != '*'){
			return false;
			}
	    else {
	        return true;
	        }
		}
		
	public static int validBoard(char[][] board) {
	    if (board == null)
	        return -1; // board is null
	    if (board.length != 10 || board[0].length != 10)
	        return -2; // wrong size
	    for (char[] row : board) {
	        for (char valid : row) {
	             if (!boardSquare(valid))
	                 return -3; // invalid square
	            }
	        }
	        return 1; // valid board
	    }
	
}	// ignore
/*
public boolean boardSquare(char valid) {
    return valid == '.' || valid == 'S' || valid == '*';
} // 1.1. Valid Board Method (Boolean)
public int validBoard(char[][] board) {
    if (board == null) {
        return -1; // null board
    }
    if (board.length != 10 || board[0].length != 10) {
        return -2; // wrong size
    }
    for (int row = 0; row < 10; row++) {
        for (int column = 0; column < 10; column++) {
            if (!boardSquare(board[row][column])) {
                return -3; // invalid square
            }
        }
    }
    return 0; // valid board
}*/