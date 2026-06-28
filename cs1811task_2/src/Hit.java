public class Hit {	//Ignore
	
	public static int getHit(int row, char column, char[][] board) {
	    if (row < 1 || row > 10) {
	        return -1; //Invalid row
	    }
	    if (column < 'A' || column > 'J') {
	        return -2; //Invalid column
	    }
	    char square = board[row - 1][column - 'A'];
	    if (square == 'S') {
	        return 1; //Hit
	    } else if (square == '.') {
	        return 2; //Miss
	    } else {
	        return 3; //Repeated hit
	    }
	}
	
}	//Ignore
/*
public int getHit(int row, char column, char[][] board) {
    if (row < 1 || row > 10) {
        return -1; //Invalid row
    }
    if (column < 'A' || column > 'J') {
        return -2; //Invalid column
    }
    char valid = board[row - 1][column - 'A'];
    if (valid == 'S') {
        return 1; //Hit
    } else if (valid == '.') {
        return 2; //Miss
    } else {
        return 3; //Repeated hit
    }
}

public static int getHit(int row, char column, char[][] board) {
	if (row < 0 || row >= 10)
       	return -1; //Invalid row number
    if (column < 'A' || column > 'J')
       	return -2; //Invalid column
    if (board[row][column - 'A'] == 'S')
       	return 1; //Hit
    if (board[row][column - 'A'] == '.')
       	return 2; //Miss
    if (board[row][column - 'A'] == '*')
    	return 3; //Repeated hit
	return -3; //Unknown condition
}
*/