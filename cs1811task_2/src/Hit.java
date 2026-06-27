public class Hit {	// ignore
	
	public static int getHit(int row, char column, char[][] board) {
        if (row < 0 || row >= 10)
            return -1; // invalid row number
        if (column < 'A' || column > 'J')
            return -2; // invalid column
        if (board[row][column - 'A'] == 'S')
            return 1; // hit
        if (board[row][column - 'A'] == '.')
            return 2; // miss
        if (board[row][column - 'A'] == '*')
            return 3; // repeated hit
        return -3; // unknown condition
    }
	
}	// ignore
/*
public int getHit(int row, char column, char[][] board) {
    if (row < 1 || row > 10) {
        return -1; // invalid row
    }
    if (column < 'A' || column > 'J') {
        return -2; // invalid column
    }
    char valid = board[row - 1][column - 'A'];
    if (valid == 'S') {
        return 1; // hit
    } else if (valid == '.') {
        return 2; // miss
    } else {
        return 3; // repeated hit
    }
}*/