public class Bonus_Question {	//Ignore
	
	public static boolean boardSquare(char valid) {	//1.1 Valid Board Square
		return valid == '.' || valid == 'S' || valid == '*';
	}	//1.1 Valid Board Square
	
	public static int validBoard(char[][] board) { //1.2 Valid Board
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
	} //1.2 Valid Board
	
	public static double[] calculateDamage(char[][] board) {
	    double[] damageReport = new double[4];
	    double[] totalDamage = new double[4];
	    int[] shipCount = new int[4];
	    for (int i = 0; i < 4; i++) {
	        damageReport[i] = -1.0; //No ship of this type found
	        totalDamage[i] = 0.0;
	        shipCount[i] = 0;
	    }
	    if (validBoard(board) != 1) {
	        return damageReport; //Invalid board
	    }
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
	                int index = getShipIndex(length);
	                if (index != -1) {
	                    double damagePercent = ((double) hitSquares / length) * 100.0;
	                    totalDamage[index] = totalDamage[index] + damagePercent;
	                    shipCount[index]++;
	                }
	            } else {
	                column++;
	            }
	        }
	    }
	    for (int i = 0; i < 4; i++) {
	        if (shipCount[i] > 0) {
	            damageReport[i] = totalDamage[i] / shipCount[i];
	        }
	    }
	    return damageReport;
	}

	public static int getShipIndex(int length) {
	    if (length == 5) {
	        return 0; //Carrier
	    } else if (length == 4) {
	        return 1; //Battleship
	    } else if (length == 3) {
	        return 2; //Cruiser
	    } else if (length == 2) {
	        return 3; //Destroyer
	    } else {
	        return -1;
	    }
	}

}	//Ignore
/*
public int[] damage(char[][] board) {
    int[] damageReport = new int[4];
    //Add logic to calculate damage for each ship type
    return damageReport;
}

	public static double[] calculateDamage(char[][] board) {
        double[] damageReport = new double[4];
        int[] shipCount = new int[4];
        //Initialises damage report and ship counts
        for (int i = 0; i < 4; i++) {
            damageReport[i] = -1.0; //Error value for ships not found
            shipCount[i] = 0;
        }
        //Counts ships and damage
        for (char[] row : board) {
            for (char square : row) {
                switch (square) {
                    case 'S':
                        shipCount[0]++;
                        break;
                    case '*':
                        shipCount[1]++;
                        break;
                    case '1':
                        shipCount[2]++;
                        break;
                    case '2':
                        shipCount[3]++;
                        break;
                }
            }
        }
        //Calculates damage percentages
        for (int i = 0; i < 4; i++) {
            if (shipCount[i] > 0) {
                damageReport[i] = (double) shipCount[i] / (double) (i + 1);
            }
        }
        return damageReport;
    }
*/