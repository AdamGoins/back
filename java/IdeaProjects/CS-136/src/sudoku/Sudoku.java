package sudoku;

/**
 * Adam Goins
 *
 * Lab 5: Sudoku
 * 2017.08.10
 */
public class Sudoku {

    // The game board is a two-dimensional array, or a matrix of characters.
    char[][] chars = new char[9][9];

    /**
     * Zero-Argument constructor for the Sudoku class. Exists for problem requirements, isn't used.
     *
     * Lines of code: 3
     */
    public Sudoku() {

    }

    /**
     * One-Argument constructor for the Sudoku class, receives a string containing the starting configuration to the Sudoku puzzle.
     * The string is then parsed and each character is placed into the appropriate square on the game board.
     *
     * @param starting_configuration: The starting configuration of the game board.
     *
     * Lines of code: 13
     */
    public Sudoku(String starting_configuration) {
        int col = 0;
        int row = 0;
        for (char character: starting_configuration.toCharArray()) {
            if (character == '\n') {
                row++;
                col = 0;
                continue;
            }
            chars[col][row] = character;
            col++;
        }
    }


    /**
     * The getSquare() method receives the index of a row and column and returns the character from the board at those indices.
     *
     * @param row: The rowIndex of where the character to be retrieved is located.
     * @param col: The columnIndex of where the character to be retrieved is located.
     *
     * @return char: The character from the board matrix at the specified indices.
     *
     * Lines of code: 3
     */
    public char getSquare(int row, int col) {
        return chars[col][row];
    }


    /**
     * The setSquare() method receives a row and column index value, as well as a character to set the value to.
     * The board matrix is then accessed at the indices specified and the value of it is set to the char value received in the method parameter.
     *
     * @param row: The rowIndex of where the character to be retrieved is located.
     * @param col: The columnIndex of where the character to be retrieved is located.
     * @param value: The value of what to set the specified position in the matrix to.
     *
     * Lines of code: 3
     */
    public void setSquare(int row, int col, char value) {
        chars[col][row] = value;
    }


    /**
     * The checkCols() method loops through the matrix, checking the characters in each column against each other.
     * If a character exists more than once in a row, then the method returns false. Otherwise it returns true if only
     * Unique characters exist in the column.
     *
     * @return boolean: Columns contain only unique characters
     *
     * Lines of code: 11
     */
    private boolean checkCols() {
        for (int i = 0; i < 9; i++) {
            String characters = "";
            for (char c: chars[i]) {
                if (c == ' ') continue;
                if (characters.indexOf(c) == -1) characters += c;
                else return false;
            }
        }
        return true;
    }


    /**
     * The checkRows() method loops through the matrix, checking the characters in each row against each other.
     * If a character exists more than once in a row, then the method returns false. Otherwise it returns true if only
     * Unique characters exist in the row.
     *
     * @return boolean: Rows contain only unique characters
     *
     * Lines of code: 12
     */
    private boolean checkRows() {
        for (int row = 0; row < 9; row++) { // For each row
            String characters = "";  // String that will contain all characters in a row
            for (int column = 0; column < 9; column++) {  // For each column.
                char a = chars[column][row];  // The character at the specific index of the row
                if (a == ' ') continue;  // If the character is a space, we ignore it and continue to the next iteration
                if (characters.indexOf(a) == -1) characters += a; // If the characters of the row don't contain the character we've encountered, we add it to it.
                else return false;// If we've already encountered the character, then it exists in the row more than once and false is returned
            }
        }
        return true;  // If we make it this far without returning false, it means all characters in the row are unique.
    }


    /**
     * The checkSquares() method loops through the 9 different implied subsquares inside the main sudoku board
     * And checks each character against every other character in that subsquare to ensure each character exists
     * Only once. Spaces are ignored in this verification algorithm
     *
     * @return boolean: If each character in each subsquare is appears only once.
     *
     * Lines of code: 17
     */
    private boolean checkSquares() {
        for (int boxIndex = 0; boxIndex < 9; boxIndex++) { // There are 9 imaginary sub-boxes that we need to check.
            int mod = boxIndex % 3; // Each box contains a 3x3 matrix, the mod is the relationship between that 3x3 matrix and the row/column indexes of the main board.
            int rowStart = boxIndex - mod; // The starting row index for the box
            int colStart = mod * 3; // The starting column index for the box
            String boxString = "";  // And the end of the next for loops, this string contains all characters in a box
            for (int rowIndex = rowStart; rowIndex < rowStart + 3; rowIndex++) {      // For each row in the box
                for (int colIndex = colStart; colIndex < colStart + 3; colIndex++) {  // For each column in the box
                    String character = Character.toString(chars[colIndex][rowIndex]); // Grabbing the character at the proper index
                    if (character.equals(" ")) continue; // If the character is a space, we ignore it and reset the loop to the next iteration
                    if (boxString.contains(character)) return false; // If we're looking at a character and it's already been encountered, it's been encountered twice, which makes the function return false
                    boxString += character; // If the character is unique, add it to the string.
                }
            }
        }
        return true; // If we make it this far without returning false, it means every character is unique
    }


    /**
     * The isValid() method returns true if all rows are unique, all columns are unique, and each box is unique.
     *
     * @return boolean: Rows, Columns, and Squares are all unique
     *
     * Lines of code: 3
     */
    public boolean isValid() {
        return checkCols() && checkRows() && checkSquares();
    }


    /**
     * the isFilled() method loops through the board and evaluates each character. If that character is a space, then we return false.
     *
     * @return: boolean: All rows are filled
     *
     * Lines of code: 9
     */
    private boolean isFilled() {
        for (int row = 0; row < 9; row++) { // For each row
            for (int col = 0; col < 9; col++) { // For each column
                char character = chars[col][row]; // Character in matrix at this specific row/col index
                if (character == ' ') return false; // Return false if a space is encountered
            }
        }
        return true; // If we make it this far after looping through the entire matrix, it means the board is full
    }


    /**
     * the isSolved() method returns true if the board is filled, and every filled position is a valid one.
     *
     * @return boolean: All squares are filled with a valid position.
     *
     * Lines of code: 3
     */
    public boolean isSolved() {
        return isValid() && isFilled();
    }
}