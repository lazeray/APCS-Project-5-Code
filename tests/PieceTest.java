import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    void testPieceConstructor() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(2, 1, board);

        assertEquals(2, piece.getCol(), "Column should match");
        assertEquals(1, piece.getColor(), "Color should match");
    }


    @Test
    void testGetCol() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(2, 1, board);

        assertEquals(2, piece.getCol(), "Column should match");
    }

    @Test
    void testGetRow() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(2, 1, board);

        assertEquals(4, piece.getRow(), "Row should be determined by findRow method");

        Board board2 = new Board(7, 7);
        Piece piece2 = new Piece(2, 1, board2);

        assertEquals(6, piece2.getRow(), "Row should be determined by findRow method");
    }

    @Test
    void testGetColor() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(2, 1, board);

        assertEquals(1, piece.getColor(), "Color should match");
    }
}