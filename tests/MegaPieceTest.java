import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegaPieceTest {
    @Test
    void testFindRowMegaPiece() {
        Board board = new Board(5, 5);
        MegaPiece megaPiece = new MegaPiece(2, 1, board);

        assertEquals(board.getBoardPieces().length - 2, megaPiece.getRow(), "MegaPiece should be placed at the second to last row");
    }
    @Test
    void testFindRowMegaPiece2() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(1, 2, board);
        board.placePiece(piece);
        MegaPiece megaPiece = new MegaPiece(2, 1, board);

        assertEquals(board.getBoardPieces().length - 3, megaPiece.getRow(), "MegaPiece should be placed at the second to last row");
    }

}