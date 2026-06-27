public class Number_Sunk {	// ignore

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
	
}	// ignore
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
*/