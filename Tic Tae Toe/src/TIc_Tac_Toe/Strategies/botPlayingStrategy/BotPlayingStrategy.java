package TIc_Tac_Toe.Strategies.botPlayingStrategy;

import TIc_Tac_Toe.Model.Board;
import TIc_Tac_Toe.Model.Move;
import TIc_Tac_Toe.Model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
