public class Board {
    // declare instance variables here!
    public Board(int x, int y) { // constructor!

    }
    public void placePiece(Piece p) { // updates the state of the board with the information of the Piece
        if (p instanceof MegaPiece) {
            // hmm
        } else {
            // hmm
        }
    }


    public int[][] getBoardPieces() { // getter function for boardPieces array
        return null;
    }

    public void displayAll() { // displays the entire board
        // that's quite a nice display we've got right now (displays nothing)
    }
    public boolean checkForWin(int player) { //FIXME
        return false;
    }

}
