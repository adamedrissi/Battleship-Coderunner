public class Valid_Board_Square { // ignore
	
	public static Boolean boardSquare(char valid) {
		if (valid != '.' && valid != 'S' && valid != '*'){
            return false;
        }
        else {
            return true;
        }
	}
	
	// METHOD 2 (Boolean, return char)
		public static Boolean validBoardSquare(char valid) {
	        return valid == '.' || valid == 'S' || valid == '*';
	    }
		
} // ignore
/*
public boolean boardSquare(char valid) {
    return valid == '.' || valid == 'S' || valid == '*';
}*/