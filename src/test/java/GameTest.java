import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

    @ParameterizedTest
    @CsvSource({"4 ,1", "5,2", "0,3", "2,4"})
    void playTicTacToeWhenExceptionOccursTest(int xCoordinate, int yCoordinate) {
        //Arrange
        Game game = new Game();
        //Act and catch Exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.playGame(xCoordinate, yCoordinate));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "1,2", "1,2", "3,3", "3,3"})
    void playTicTacToeWhenPlaceAlreadyTakenTest(int xCoordinate, int yCoordinate) {
        //Arrange
        Game game = new Game();
        game.playGame(xCoordinate, yCoordinate);
        //Act and catch Exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.playGame(xCoordinate, yCoordinate));
    }

    @Test
    void playTicTacToeWhenColWinnerConditionTest() {
        //Arrange
        Game game = new Game();
        //Act
        game.playGame(1, 1);//x
        game.playGame(2, 2);//o
        game.playGame(2, 1);//x
        game.playGame(3, 3);//o
        String msg = game.playGame(3, 1);
        //Assert
        Assertions.assertEquals("X  is the winner", msg);

    }

    @Test
    void playTicTacToeWhenRowWinnerConditionTest() {
        //Arrange
        Game game = new Game();
        //Act and catch Exception
        game.playGame(1, 1);//x
        game.playGame(2, 2);//o
        game.playGame(1, 2);//x
        game.playGame(3, 3);//o
        String msg = game.playGame(1, 3);
        //Assert
        Assertions.assertEquals("X  is the winner", msg);

    }

    @Test
    void playTicTacToeWhenDiagonalWinnerConditionTest() {
        //Arrange
        Game game = new Game();
        //Act and catch Exception
        game.playGame(1, 1);//x
        game.playGame(2, 1);//o
        game.playGame(2, 2);//x
        game.playGame(2, 3);//o
        String msg = game.playGame(3, 3);//x
        //Assert
        Assertions.assertEquals("X  is the winner", msg);

    }

    @Test
    void playTicTacToeWhenDrawConditionTest() {
        //Arrange
        Game game = new Game();
        //Act
        game.playGame(2, 2);//x
        game.playGame(2, 1);//o
        game.playGame(3, 2);//x
        game.playGame(1, 2);//o
        game.playGame(3, 1);//x
        game.playGame(1, 3);//o
        game.playGame(1, 1);//x
        game.playGame(3, 3);//o
        String msg = game.playGame(2, 3);//x
        //Assert
        Assertions.assertEquals("No winner, game is ended in draw", msg);

    }


}
