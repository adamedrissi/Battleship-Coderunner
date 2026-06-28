public class Valid_Board {	//Ignore
	
	public static boolean boardSquare(char valid) {	//1.1 Valid Board Square
		return valid == '.' || valid == 'S' || valid == '*';
	}	//1.1 Valid Board Square
	
	public static int validBoard(char[][] board) {
	    if (board == null) {
	        return -1; //Board is null
	    }
	    if (board.length != 10) {
	        return -2; //Wrong number of rows
	    }
	    for (int row = 0; row < 10; row++) {
	        if (board[row] == null || board[row].length != 10) {
	            return -2; //Wrong number of columns
	        }
	        for (int column = 0; column < 10; column++) {
	            if (!boardSquare(board[row][column])) {
	                return -3; //Invalid square
	            }
	        }
	    }
	    return 1; //Valid board
	}
	
}	//Ignore
/*
public boolean boardSquare(char valid) {
    return valid == '.' || valid == 'S' || valid == '*';
} // 1.1. Valid Board Method (Boolean)
public int validBoard(char[][] board) {
    if (board == null) {
        return -1; //null board
    }
    if (board.length != 10 || board[0].length != 10) {
        return -2; //wrong size
    }
    for (int row = 0; row < 10; row++) {
        for (int column = 0; column < 10; column++) {
            if (!boardSquare(board[row][column])) {
                return -3; // invalid square
            }
        }
    }
    return 0; //valid board
}

public static Boolean boardSquare(char valid) {	//1.1 Valid Board Method (Boolean)
	if (valid != '.' && valid != 'S' && valid != '*'){
		return false;
	}
	else {
		return true;
	}
}
		
public static int validBoard(char[][] board) {
	if (board == null)
		return -1; //Board is null
	if (board.length != 10 || board[0].length != 10)
	        return -2; //Wrong size
	for (char[] row : board) {
	        for (char valid : row) {
	             if (!boardSquare(valid))
	                 return -3; //Invalid square
	            }
	        }
	        return 1; //Valid board
	    }
*/