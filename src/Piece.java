public class Piece {
    // instance variables go here!

    public Piece(int col, int color, Board board) { // constructor!

    }

    private int findRow(int column, Board board) { // given the state of the board, and a column, it returns the row
        int[][] boardPieces = board.getBoardPieces();
        if (this instanceof MegaPiece) {
            return 0;
        } else {
            return 0;
        }
    }
    public int getCol() {
        return 0;
    } //FIXME
    public int getRow() {
        return 0;
    }
    public int getColor() {
        return 0;
    }
}
