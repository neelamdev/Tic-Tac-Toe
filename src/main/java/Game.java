public class Game {
    String lastTurn = " ";
    String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    public String playGame(int x, int y) {
        checkIfTryingToPlaceMarkOnBoard(x, y);
        if (isWinner())
            return (lastTurn + "  is the winner");
        else
            return "No winner, game is ended in draw";
    }

    public void checkIfTryingToPlaceMarkOnBoard(int x, int y) {
        if (x < 1 || x > 3)
            throw new IllegalArgumentException("you are trying to place outside grid");
        if (y < 1 || y > 3)
            throw new IllegalArgumentException("you are trying to place outside grid");
        if (board[x - 1][y - 1].equals(" ")) {
            board[x - 1][y - 1] = alternateTurns();
            lastTurn = alternateTurns();
        } else
            throw new IllegalArgumentException("you are trying to a place which is already taken");
    }

    public String alternateTurns() {
        if (lastTurn.equals("X"))
            return "O";
        else return "X";
    }

    public boolean isWinner() {
        boolean isWin = false;
        System.out.println("who is playing " + lastTurn);
        if ((board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && !board[0][2].equals("")) ||//row 1
                (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && !board[1][2].equals("")) ||//row 2
                (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && !board[2][2].equals("")) ||//row 3
                (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && !board[2][0].equals("")) ||//col 1
                (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && !board[2][1].equals("")) ||//col 2
                (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && !board[2][2].equals("")) ||//col 3
                (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[2][2].equals("")) ||//diagonal 1
                (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[2][0].equals("")))//diagonal 1
            isWin = true;
        return isWin;

    }
}
