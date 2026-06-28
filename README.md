CompSci Yr 1 CS1702 Task #2 (1811) - 2336827 Adam El Edrissi Calvo Flores

ORIGINAL EXAMINATION DATE: 16/05/2024 09:30 BST (3h)


MAIN OBJECTIVE AND BRIEF DESCRIPTION OF THE ASSESSMENT

The overall objective of this assignment is to produce Java programming code that forms a set of functions that can be used to simulate/play the game “Battleships”.

•	The aim of the game is for each player to sink their opponent’s ships (fleet) first.

•	Each player has two sheets/boards (10 x 10 squares in size).

•	One (kept in secret from the other player) stores the location of the players ships.

•	The other is used to record where the player has attacked and whether each of their attacks hit a ship or landed in open sea.

•	One player goes first and states a location (pair of coordinates) where they are attacking.

•	The other player will state whether one of their ships was hit or whether it was a miss.

•	If a ship is sunk, then the player should indicate this.

•	The players record where they have attacked and where the opposing player has attacked.

•	The rounds continue until one of the players is the winner.

•	The game starts with a fixed number of ships.

•	Each ship varies in size between 2 and 5 squares (length) but are always one square wide.

For this assessment, a complete game is not being written, but a series of Java methods that could be used in a fully-fledged implementation. We are also just going to be working with the board the players record the location of their own ships (fleet) on.									

During the CodeRunner examination/test you will be asked to submit one or more Java methods [as needed, see below] where the solutions to the tasks listed are implemented as public static methods.
When completing the tasks, please note the following:

1)	A Battleship board will be represented as a ten (10) row by ten (10) column char array. Note that row indices range between 1 and 10 and column indices range between ‘A’ and ‘J’ (upper case ONLY parameters – see below), whilst Java arrays start at zero (0). Position “1A” will be (0,0) in a Java array.

2)	The board (Java representation) can only contain the characters ‘.’, ‘S’ or ‘*’. Note that a ‘.’ indicates open water, a ‘S’ (case sensitive) represents part of ship and a ‘*’ represents part of a damaged ship. A ship that consists entirely of character ‘S’ is undamaged, a mix of ‘S’ and ‘*’ is damaged and one consisting entirely of character ‘*’ has sunk.

3)	Ships will only be positioned horizontally and will not be adjacent horizontally (i.e. will not be touching any other ship – see the example of a Cruiser and a damaged Destroyer on row 9 above). In the example board above (rows 2 and 3) there is a two-space ship (undamaged Destroyer) and a two-space ship (sunk Destroyer), not two two-space ships both 50% damaged.

4)	If a board is the specified size (10×10 char array) and contains acceptable characters (as per #2 immediately above), then it is valid.

Your solutions will be tested rigorously [automatically]. For example, invalid input and test data (null, the wrong size, wrong characters etc..) will be used. Your methods MUST be able to cater for this. The exact return conditions [error values] will be specified later, so decide it yourself for now.


FUNCTIONAL REQUIREMENTS FOR THE TASK #2 ASSESSMENT

1.1 Valid Board Square

Marks: 2

Write a method, that returns true or false depending on whether a character (char) [the input] is a valid board square (‘.’, ‘S’ or ‘*’) as defined/described above.


1.2 Valid Board

Marks: 3

Write a method that returns a number of different values (integer) depending on if the input board is valid/invalid (as defined/described above). Note that valid means the board is the correct size, not null, and each square contains a valid character. You DO NOT need to check if there are any ships that do not adhere to the specification.
((Write a method that returns true if the input board is a valid board (as defined/described above), return false otherwise.))
The possible return values are as follows:

•	A value indicating that the board is null.

•	A value indicating that the board is the wrong size.

•	If the board is the correct size, a value indicating that there is at least one invalid square as defined in question 1.1 and above.

•	A value indicating that the board is valid.
You need a clear understanding of what a valid board is.


1.3 Number Sunk

Marks: 3

Write a method that when given a valid board (see above – assume the input board is valid) returns the number of sunk ships. If there are no ships on the board (this is still a valid board) a value should be returned. A sunk ship consists entirely of ‘*’s. With this question and further questions, return values for various (error) conditions are to be returned.
Note that the exact values (return integer values) required will be specified later, so randomise the values for now.


1.4 Hit

Marks: 3

Write a method that when given an input integer (row), an input character (column) and a valid board (see above – assume the input board is valid) returns an integer indicating the following conditions:

•	A value indicating that the row number is invalid. 

•	A value indicating that the column is invalid.

•	A value indicating a hit (square contains a ‘S’).

•	A value indicating a miss (square contains a ‘.’).

•	A value indicating a repeated hit (square contains a ‘*’).

Maybe reuse the code from [a] previous[s] answer[s].
Note that the exact values (return integer values) required will be specified later, so randomise the values for now.


1.5 Count Ships

Marks: 4

Write a method that when given the following input parameters:

•	A valid board (see above – assume the input board is valid).

•	A String indicating the ship type. This will either be a number (ID) OR ship type (Class).

•	Damage type, the parameter will be a String, indicating undamaged, damaged, sunk or all types.

returns the number (count) of ships that match the parameters. Additional return values for error conditions also need handling:

•	A value indicating the ship type parameter is invalid.

•	A value indicating the damage type parameter is invalid.

•	If there are no ships on the board (this is still a valid board) a value should be returned.

Additional return values for error conditions also need handling.
Note that the exact values (return integer values) required will be specified later, so randomise the values for now.


Bonus Five (5) Marks

Marks: 5

Write a method that returns a damage report for a given board. Each type of ship should be identified within the board and the percentage of damage calculated (the average damage per ship within each class/type of ship). The return value will be an array/list type structure where the first position represents the damage report for ship ID 1, etc… If there are no ships of a given type then the corresponding array position (return value) should contain an error value (specified later, so decide it yourself for now). The board might not be valid and hence there will be return values for error conditions needed.


FORMAT OF THE ASSESSMENT

Additional Details to Note:

1.	Your methods just need to answer questions 1-6 and no more.

2.	You will not need a user interface or any input from any user.

3.	None of your methods should display any text to the screen, i.e. there is no need for calling System.out.println.

4.	Do not use any import statements. These [the standard ones we use in the module] will be done for you in CodeRunner, however we cannot import every possible library. If you are using a non-standard library, let us know and we will import it. Note that anything not imported can be accessed directly, e.g. java.util.HashMap.

5.	All submitted code will be run through a plagiarism and similarity checker.


APPENDIX A: GRADING CRITERIA

The CodeRunner test is marked out of 15 marks (see above). This will be converted to a percentage and then a grade point assigned [the full range F – A* for this task] as per Senate Regulations SR2.

Percentage = Mark / 15 × 100%

Task #2	Grade Range

•	More than 70%	= A (A- to A*)

•	>=60% and <70% = B (B- to B+)

•	>=50% and <60% = C (C- to C+)

•	>=40% and <50% = D (D- to D+)

•	>=30% and <40% = E (E- to E+)

•	Less than 30% = F
