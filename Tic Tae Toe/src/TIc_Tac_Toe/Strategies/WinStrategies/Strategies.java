package TIc_Tac_Toe.Strategies.WinStrategies;

import java.util.List;

import TIc_Tac_Toe.Model.Board;
import TIc_Tac_Toe.Model.Move;

public interface Strategies {
    public Boolean checkWinner(Board boad ,List<Move>moves);
}
