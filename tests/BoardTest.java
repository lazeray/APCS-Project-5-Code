import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testConstructorAndGetBoardPieces() {
        int rows = 3;
        int cols = 4;

        Board board = new Board(rows, cols);
        int[][] boardPieces = board.getBoardPieces();

        assertEquals(rows, boardPieces.length, "Rows should match");
        assertEquals(cols, boardPieces[0].length, "Columns should match");

        // Check that all elements are initialized to 0
        for (int[] row : boardPieces) {
            for (int cell : row) {
                assertEquals(0, cell, "All elements should be initialized to 0");
            }
        }
    }
    @Test
    void testPlacePiece() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(2, 1, board);
        board.placePiece(piece);
        Piece piece2 = new Piece(2, 2, board);
        board.placePiece(piece2);
        Piece piece3 = new Piece(1, 1, board);
        assertEquals(board.getBoardPieces().length - 1, piece.getRow(), "Regular piece should be placed at the last row");
        assertEquals(board.getBoardPieces().length - 2, piece2.getRow(), "Piece should stack ontop of othe previous piece");
        assertEquals(board.getBoardPieces().length - 1, piece3.getRow(), "Piece should rest at bottom of board");
    }

    @Test
    void testCheckForWinHorizontal() {
        Board board = new Board(9, 9);
        board.placePiece(new Piece(2, 1, board));  // Player 1 places a piece at (0, 0)
        board.placePiece(new Piece(2, 1, board));
        board.placePiece(new Piece(2, 1, board));
        board.placePiece(new Piece(2, 1, board));
        board.placePiece(new Piece(2, 1, board));

        assertTrue(board.checkForWin(1));  // Player 1 should win horizontally
    }
    @Test
    void testCheckForWinVertical() {
        Board board = new Board(9, 9);
        board.placePiece(new Piece(1, 2, board));  // Player 2 places a piece at (0, 0)
        board.placePiece(new Piece(2, 2, board));
        board.placePiece(new Piece(3, 2, board));
        board.placePiece(new Piece(4, 2, board));
        board.placePiece(new Piece(5, 2, board));

        assertTrue(board.checkForWin(2));  // Player 2 should win vertically
    }
    @Test
    public void testCheckForWinDiagonalDown() {
        Board board = new Board(9, 9);
        board.placePiece(new Piece(5, 1, board));
        board.placePiece(new Piece(5, 1, board));
        board.placePiece(new Piece(5, 1, board));
        board.placePiece(new Piece(5, 1, board));
        board.placePiece(new Piece(5, 2, board));
        board.placePiece(new Piece(4, 1, board));
        board.placePiece(new Piece(4, 1, board));
        board.placePiece(new Piece(4, 1, board));
        board.placePiece(new Piece(4, 2, board));
        board.placePiece(new Piece(3, 1, board));
        board.placePiece(new Piece(3, 1, board));
        board.placePiece(new Piece(3, 2, board));
        board.placePiece(new Piece(2, 1, board));
        board.placePiece(new Piece(2, 2, board));
        board.placePiece(new Piece(1, 2, board));

        assertTrue(board.checkForWin(2));
    }

    @Test
    public void testCheckForWinNoWin() {
        Board board = new Board(9, 9);
        board.placePiece(new Piece(0, 0, board));
        board.placePiece(new Piece(0, 1, board));
        board.placePiece(new Piece(0, 2, board));
        board.placePiece(new Piece(0, 3, board));
        board.placePiece(new Piece(0, 4, board));

        assertFalse(board.checkForWin(1));  // No player should win
        assertFalse(board.checkForWin(2));
    }


}