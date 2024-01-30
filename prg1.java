import java.util.Scanner;

public class ChessGame {

    private static char[][] board = {
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}
    };

    private static boolean isWhiteTurn = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.println((isWhiteTurn ? "White" : "Black") + "'s turn.");
            System.out.print("Enter your move (e.g., e2e4): ");
            String move = scanner.nextLine().toLowerCase();

            if (isValidMove(move)) {
                makeMove(move);
                isWhiteTurn = !isWhiteTurn;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidMove(String move) {
        if (move.length() != 4) {
            return false;
        }

        int fromRow = 8 - (move.charAt(1) - '0');
        int fromCol = move.charAt(0) - 'a';
        int toRow = 8 - (move.charAt(3) - '0');
        int toCol = move.charAt(2) - 'a';

        if (fromRow < 0 || fromRow >= 8 || fromCol < 0 || fromCol >= 8 ||
            toRow < 0 || toRow >= 8 || toCol < 0 || toCol >= 8) {
            return false;
        }

        char piece = board[fromRow][fromCol];
        boolean isWhitePiece = Character.isUpperCase(piece);

        if ((isWhiteTurn && !isWhitePiece) || (!isWhiteTurn && isWhitePiece)) {
            return false; // It's not the player's piece
        }

        // Add more logic to check if the move is valid for the specific piece type (e.g., pawn, rook, etc.)

        return true;
    }

    private static void makeMove(String move) {
        int fromRow = 8 - (move.charAt(1) - '0');
        int fromCol = move.charAt(0) - 'a';
        int toRow = 8 - (move.charAt(3) - '0');
        int toCol = move.charAt(2) - 'a';

        char piece = board[fromRow][fromCol];
        board[fromRow][fromCol] = ' ';
        board[toRow][toCol] = piece;
    }
}
