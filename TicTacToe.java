
//Tic Tac Toe game
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        char board[][] = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';

            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner scan = new Scanner(System.in);

        while (!gameover) {
            printBoard(board);
            System.out.println("Enter the Coordinates ::");
            System.out.println("Player " + player + " enter:");
            int row = scan.nextInt();
            int col = scan.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameover = haveWon(board, player);
                if (gameover) {
                    System.out.println("Player " + player + " has won:");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid Move...Try Again!");
            }

        }
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }

    public static boolean haveWon(char[][] board, char player)
    // for row Checking
    {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }

        }
        // for Col Checking
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }

        }
        // for Diagonal Checking

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;

    }
}
