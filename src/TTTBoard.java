public class TTTBoard {
    private char[][] board;

    public TTTBoard() {
        board = new char[3][3];
        reset();
    }

    public void reset() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    public String toString() {
        String result = "\n";
        for (char[] row : board) {
            for (char c : row) {
                result += c + " ";
            }
            result += "\n";
        }
        return result;
    }

    public boolean placeXorO(char player, int row, int col) {
        if (board[row - 1][col - 1] == '-') {
            board[row - 1][col - 1] = player;
            return true;
        } else
            return false;
    }

    // returns the winning player's char, or '-' if there is not winner yet
    public char getWinner() {
        for (int row = 0; row < 3; row++) {
            char rowWinner = checkRow(row);
            if (rowWinner != '-') { // we have a winner
                return rowWinner;
            }
        }
        for (int col = 0; col < 3; col++) {
            char colWinner = checkCol(col);
            if (colWinner != '-') {
                return colWinner;
            }
        }
        char diagonalWinner = checkDiagonal();
        if (diagonalWinner != '-') {
            return diagonalWinner;
        }
        return '-';
    }

    // returns 'X' if X has won, 'O' if O has won, or '-'
    private char checkRow(int row) {
        char rWinner = board[row][0];
        for (int col = 1; col < 3; col++) {
            if (board[row][col] != rWinner) {
                return '-';
            }
        }
        return rWinner;
    }

    private char checkCol(int col) {
        char cWinner = board[0][col];
        for (int row = 1; row < 3; row++) {
            if (board[row][col] != cWinner) {
                return '-';
            }
        }
        return cWinner;
    }

    private char checkDiagonal() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return board[2][0];
        } else
            return '-';

    }

    //return true if all spaces are occupied by player chars
    public boolean full() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TTTBoard b = new TTTBoard();
        System.out.println(b);
        b.placeXorO('X', 1, 1);
    }
}
