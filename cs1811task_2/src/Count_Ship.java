public class Count_Ship {	//Ignore
	
	public static int countShip(char[][] board, String shipType, String damageType) {
	    int targetLength = getShipLength(shipType);
	    if (targetLength == -1) {
	        return -1; //Invalid ship type
	    }
	    if (!validDamageType(damageType)) {
	        return -2; //Invalid damage type
	    }
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
	                if (length == targetLength) {
	                    String actualDamageType;
	                    if (hitSquares == 0) {
	                        actualDamageType = "undamaged";
	                    } else if (hitSquares == length) {
	                        actualDamageType = "sunk";
	                    } else {
	                        actualDamageType = "damaged";
	                    }
	                    if (damageType.equals("all") || damageType.equals(actualDamageType)) {
	                        count++;
	                    }
	                }
	            } else {
	                column++;
	            }
	        }
	    }
	    return count;
	}

	public static int getShipLength(String shipType) {
	    if (shipType == null) {
	        return -1;
	    }
	    if (shipType.equals("1") || shipType.equals("Carrier")) {
	        return 5;
	    } else if (shipType.equals("2") || shipType.equals("Battleship")) {
	        return 4;
	    } else if (shipType.equals("3") || shipType.equals("Cruiser")) {
	        return 3;
	    } else if (shipType.equals("4") || shipType.equals("Destroyer")) {
	        return 2;
	    } else {
	        return -1;
	    }
	}

	public static boolean validDamageType(String damageType) {
	    if (damageType == null) {
	        return false;
	    }
	    return damageType.equals("undamaged")
	        || damageType.equals("damaged")
	        || damageType.equals("sunk")
	        || damageType.equals("all");
	}
	
}	//Ignore
/*
public int countShip(char[][] board, String shipType, String damageType) {
	int count = 0;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (board[i][j] == 'S' || board[i][j] == '*') {
                count++;
            }
        }
    }
    //Add logic to check shipType and damageType
    return count;
    
	public static int countShip(char[][] board, String shipType, String damageType) {
        int count = 0;
        char shipChar = getShipChar(shipType);
        if (shipChar == '\0')
            return -1; //Invalid ship type
        for (char[] row : board) {
            for (char square : row) {
                if (square == shipChar || (damageType.equals("damaged") && square == '*')) {
                    count++;
                } else if (damageType.equals("sunk") && square == '*') {
                    return -3; //Error: ship cannot be sunk if not present
                }
            }
        }
        return count;
    }
	//Helper method to get ship character based on ID or class
	private static char getShipChar(String shipType) {
        switch (shipType) {
            case "Carrier":
            case "1":
                return '1';
            case "Battleship":
            case "2":
                return '2';
            case "Cruiser":
            case "3":
                return '3';
            case "Destroyer":
            case "4":
                return '4';
            default:
                return '\0'; //Invalid ship type
        }
    }
}
*/