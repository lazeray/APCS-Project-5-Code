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
            if (p.getCol() < 1 || p.getCol() > colCount - 1
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
        int connect = 0;
        int check = 1;
        if (player == 2) {
            check = 2;
        }
        for (int x = 0; x < rowCount; x++) {//x is board[x][-], y is board[-][y]
            for (int y = 0; y < colCount; y++) {
                for (int j = -5; j < 5; j++) {
                    if (y+j < 0 || y+j > colCount - 1) {
                        continue;
                    }
                    if (board[x][y+j] == check) {
                        connect++;
                    }
                    else {
                        connect = 0;
                    }
                    if (connect >= 5) {
                        return true;
                    }
                }

                //vertical
                connect = 0;
                for (int j = -5; j < 5; j++) {
                    if (x+j < 0 || x+j > rowCount - 1) {
                        continue;
                    }
                    if (board[x+j][y] == check) {
                        connect++;
                    }
                    else {
                        connect = 0;
                    }
                    if (connect >= 5) {
                        return true;
                    }
                }
                //diag1
                connect = 0;
                for (int j = -5; j < 5; j++) {
                    if (x+j < 0 || x+j > rowCount - 1
                            || y+j < 0 || y+j > colCount - 1) {
                        continue;
                    }
                    if (board[x+j][y+j] == check) {
                        connect++;
                    }
                    else {
                        connect = 0;
                    }
                    if (connect >= 5) {
                        return true;
                    }
                }
                //diag2
                connect = 0;
                for (int j = -5; j < 5; j++) {
                    if (x + j < 0 || x + j > rowCount - 1
                            || y - j < 0 || y - j > colCount - 1 ) {
                        continue;
                    } else if (board[x + j][y - j] == check) {
                        connect++;
                    } else {
                        connect = 0;
                    }
                    if (connect >= 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
