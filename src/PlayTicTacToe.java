import java.util.Scanner;

public class PlayTicTacToe {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        TTTBoard board = new TTTBoard();

        System.out.println(board);

        char player;
        if (Math.random() < 0.5)
            player = 'O';
        else
            player = 'X';

        while (!board.full() && board.getWinner() == '-') {
            System.out.println(player + "'s turn");
            System.out.print("Enter row and column separated by a space: ");
            int row = reader.nextInt();
            int col = reader.nextInt();

            boolean successful = board.placeXorO(player, row, col);
            if (!successful)
                System.out.println("Error: space is occupied!");
            else {
                System.out.println(board);
                if (player == 'X')
                    player = 'O';
                else
                    player = 'X';
            }
        } // end of while loop
        char winner = board.getWinner();
        if (winner == '-')
            System.out.println("It's a draw");
        else
            System.out.println(winner + " has won!");
    }
}
