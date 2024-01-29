public class Piece {
    // instance variables go here!
    int column;
    int row = -1;
    int color;
    Board board;
    public Piece(int col, int color, Board board) { // constructor!
        this.column = col;
        this.color = color;
        this.board = board;
    }

    private int findRow(int columnCenter, Board board) { // given the state of the board, and a column, it returns the row
        int res = Integer.MIN_VALUE;
        int highestUnoccupiedSpace = Integer.MAX_VALUE;
        if (this instanceof MegaPiece) {
            for (int i = columnCenter-1; i <= columnCenter+1; i++) { //y
                for (int j = 0; j < board.getRowCount(); j++) {
                    if (board.getBoardPieces()[j][i] != 0) {
                        res = Math.max(res, j-1);
                        break;
                    } else {
                        res = Math.max(res, j);

                    }
                }
                highestUnoccupiedSpace = Math.min(res, highestUnoccupiedSpace);
            }
        } else {
            for (int j = 0; j < board.getRowCount(); j++) {
                if (board.getBoardPieces()[j][column] != 0) {
                    highestUnoccupiedSpace = j-1;
                    break;
                } else {
                    highestUnoccupiedSpace = j;
                }
            }
        }
        if (row == -1) {
            row = highestUnoccupiedSpace;
        }
        return row;
    }
    public int getCol() {
        return column;
    }
    public int getRow() {
        return (this instanceof MegaPiece) ? this.findRow(column, board) - 1 : this.findRow(column, board);
    }
    public int getColor() {
        return color;
    }
}
