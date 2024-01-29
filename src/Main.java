import java.util.Scanner;
public class Main {
    static final int BOARDX = 5;
    static final int BOARDY = 5;
    public static void main(String[] args) {
        System.out.println("Welcome to MEGA Connect 5!");
        System.out.println("You may choose to place one 3x3 MegaPiece");
        System.out.println();
        Board board = new Board(BOARDX, BOARDY);
        Scanner input = new Scanner(System.in); //creates scanner obj
        int player = 1;
        int[] remainingMegaPiece = new int[2];
        remainingMegaPiece[0] = 1;
        remainingMegaPiece[1] = 1;

        while (true) {
            board.displayAll();
            System.out.println("Player: " + player + ":");
            if (remainingMegaPiece[player-1] == 1) {
                System.out.println("Use MegaPiece? (Y/N)?");
                char inp = input.next().charAt(0);
                if (inp == 'Y' || inp == 'y') {
                    System.out.println("Enter the column you would like to place your MegaPiece at. ");
                    int in = input.nextInt();
                    inp--;
                    MegaPiece p = new MegaPiece(in, player, board);
                    try {
                        board.placePiece(p);
                        remainingMegaPiece[player-1]--;
                        player = player % 2 + 1;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Not a valid placement.");
                    }
                    continue;
                }
            }

            System.out.println("Enter the column you would like to place your Piece at. ");
            int in = input.nextInt();
            in--;
            Piece p = new Piece(in, player, board);
            try {
                board.placePiece(p);
            } catch (IllegalArgumentException ex) {
                System.out.println("Not a valid placement.");
                continue;
            }

            if (board.checkForWin(player)) {
                System.out.println("player: " + player + " has won!");
                board.displayAll();
                break;
            }
            player = player % 2 + 1;
        }
    }
}
