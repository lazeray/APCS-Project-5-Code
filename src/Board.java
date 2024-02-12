public class Board {
    // declare instance variables here!
    private int[][] board;
    private int colCount;
    private int rowCount;
    public Board(int x, int y) {
        rowCount = x;
        colCount = y;
        board = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void placePiece(Piece p) throws IllegalArgumentException { // updates the state of the board with the information of the Piece
        if (p instanceof MegaPiece) {
            // validate col and row
            if (p.getCol() < 1 || p.getCol() >= colCount - 1
                    || p.getRow() > rowCount - 1 || p.getRow() < 2) {
                throw new IllegalArgumentException("Not a valid position for MegaPiece");
            }

            int pgetrow = p.getRow();
            for (int i = p.getCol()-1; i <= p.getCol()+1; i++) {
                for (int j = pgetrow; j > pgetrow-3; j--) {
                    board[j][i] = p.getColor();
                }
            }
        } else {
            // validate col and row
            if (p.getCol() < 0 || p.getCol() > colCount - 1
                    || p.getRow() > rowCount - 1 || p.getRow() < 0) {
                throw new IllegalArgumentException("Not a valid position for Piece");
            }
            board[p.getRow()][p.getCol()] = p.getColor();
        }
    }


    public int[][] getBoardPieces() { // getter function for boardPieces array
        return board;
    }

    public void displayAll() { // displays the entire board
        //first line of numbers
        System.out.print("  ");
        for (int i = 1; i < colCount + 1; i++) {
            System.out.print(" " + i);
            if (i < 10) {
                System.out.print(' ');
            }
        }
        //actual board, comes with hashtags
        System.out.println();
        for (int i = 0; i < rowCount; i++) {
            System.out.print("#  ");
            for (int j = 0; j < colCount; j++) {
                if (board[i][j] == 0) {
                    System.out.print(".  ");
                }
                else if (board[i][j] == 1) {
                    System.out.print("X  ");
                }
                else {
                    System.out.print("O  ");
                }
            }
            System.out.print("#");
            System.out.println();
        }
        //line of hashtags
        for (int i = 0; i < colCount + 2; i++) {
            System.out.print("#  ");
        }
        System.out.println();
    }

    public boolean checkForWin(int player) {
        if (player != 1 && player != 2) {
            throw new IllegalArgumentException("invalid player, must be 1 or 2");
        }

        int color = (player == 1) ? 1 : 2;

        for (int i = 2; i < rowCount - 2; i++) {
            for (int j = 2; j < colCount - 2; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int valueToCheck = (board[i][j] == 1) ? 1 : 2;
                // row
                for (int k = j-2; k < j+2; k++) {
                    if (board[i][k] == valueToCheck) {
                        return true;
                    }
                }
                // column
                for (int k = i-2; k < i+2; k++) {
                    if (board[k][j] == valueToCheck) {
                        return true;
                    }
                }
                // top left to bottom right
                for (int m = i-2, n = j-2; m < i+2 && n < j+2; m++, n++) {
                    if (board[m][n] == valueToCheck) {
                        return true;
                    }
                }
                // top right to bottom left
                for (int m = i-2, n = j+2; m < i+2 && n > j-2; m++, n--) {
                    if (board[m][n] == valueToCheck) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

//    public boolean checkForWin(int player) {
//        int color = -1;
//        if (player == 1) {
//            color = 1;
//        }
//        else {
//            color = 2;
//        }
//
//        int connect = 0;
//        for (int i = 0; i < colCount; i++) {
//            for (int j = 0; j < rowCount; j++) {
//                //vert
//                for (int k = j; k < rowCount; k++) {
//                    if (isOutOfBounds(i,k)) {
//                        continue;
//                    }
//                    else if (board[i][k] == color) {
//                        connect++;
//                        if (connect == 5) {
//                            return true;
//                        }
//                    }
//                    else {
//                        connect = 0;
//                    }
//                }
//                //horiz
//                connect = 0;
//                for (int k = i; k < colCount; k++) {
//                    if (isOutOfBounds(k,j)) {
//                        continue;
//                    }
//                    else if (board[k][j] == color) {
//                        connect++;
//                        if (connect == 5) {
//                            return true;
//                        }
//                    }
//                    else {
//                        connect = 0;
//                    }
//                }
//                //diag1
//                connect = 0;
//                for (int k = i; k < colCount; k++) {
//                    if (isOutOfBounds(k,k)) {
//                        continue;
//                    }
//                    else if (board[k][k] == color) {
//                        connect++;
//                        if (connect == 5) {
//                            return true;
//                        }
//                    }
//                    else {
//                        connect = 0;
//                    }
//                }
//                //diag2
//                for (int k = 0; k < 5; k++) {
//                    if (isOutOfBounds(i-k,i+k)) {
//                        continue;
//                    }
//                    else if (board[i-k][i+k] == color) {
//                        connect++;
//                        if (connect == 5) {
//                            return true;
//                        }
//                    }
//                    else {
//                        connect = 0;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public boolean isOutOfBounds(int x, int y) {
        if (x < 0 || x >= rowCount) {
            return true;
        }
        else if (y < 0 || y >= colCount) {
            return true;
        }
        return false;
    }

}
