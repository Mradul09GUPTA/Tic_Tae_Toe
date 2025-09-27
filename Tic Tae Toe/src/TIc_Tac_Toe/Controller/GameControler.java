package TIc_Tac_Toe.Controller;

import java.util.List;

import TIc_Tac_Toe.Exception.IllegalMove;
import TIc_Tac_Toe.Exception.InvalidBotCount;
import TIc_Tac_Toe.Exception.InvalidPlayerCount;
import TIc_Tac_Toe.Model.Game;
import TIc_Tac_Toe.Model.GameStatus;
import TIc_Tac_Toe.Model.Player;

public class GameControler  {
    int dimension;
    List<Player> players;
    Game game;

   public Game StartGame(int dimension, List<Player> players) throws InvalidBotCount, InvalidPlayerCount{
     
    game= Game.toBuilder()
    .setDimension(dimension)
    .setPlayers(players)
    .build();
    return game;
}
 public void makeMove(Game game) throws IllegalMove {
        game.makeMove();
    }

    public GameStatus getGameState(Game game) {
        return game.getGameStatus();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public Player getWinner() {
        return null;
    }




    
}
