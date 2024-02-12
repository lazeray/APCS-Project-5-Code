public class MegaPiece extends Piece {

    /**
     * Constructor.
     * @param col           {@code int} middle column of the megapiece
     * @param color         {@code int} color
     * @param board         {@link Board} board object
     */
    public MegaPiece(int col, int color, Board board) {
        super(col, color, board);
    }
    public int getCol() {
        return super.getCol();
    }
    public int getRow() {
        return super.getRow();
    }
    public int getColor() {
        return super.getColor();
    }


}
