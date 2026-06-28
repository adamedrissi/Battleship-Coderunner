public class Number_Sunk {	//Ignore
	
	public static int numberSunk(char[][] board) {
	    int count = 0;
	    for (int row = 0; row < 10; row++) {
	        int column = 0;
	        while (column < 10) {
	            if (board[row][column] == 'S' || board[row][column] == '*') {
	                int length = 0;
	                int hitSquares = 0;
	                while (column < 10 &&
	                      (board[row][column] == 'S' || board[row][column] == '*')) {
	                    if (board[row][column] == '*') {
	                        hitSquares++;
	                    }
	                    length++;
	                    column++;
	                }
	                if (hitSquares == length) {
	                    count++;
	                }
	            } else {
	                column++;
	            }
	        }
	    }
	    return count;
	}
	
}	//Ignore
/*
public int numberSunk(char[][] board) {
    int count = 0;
    for (int row = 0; row < 10; row++) {
        for (int column = 0; column < 10; column++) {
            if (board[row][column] == '*') {
                count++;
            }
        }
    }
    return count;
}

public static int numberSunk(char[][] board) {
	int count = 0;
    	for (char[] row : board) {
            for (char square : row) {
                if (square == '*')
                    count++;
            }
        }
	return count;
}
*/