package TIc_Tac_Toe.Strategies.WinStrategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TIc_Tac_Toe.Model.Board;
import TIc_Tac_Toe.Model.Cell;
import TIc_Tac_Toe.Model.Move;
import TIc_Tac_Toe.Model.Symbol;

public class DiagonalStrategies implements Strategies {
      private Map<Symbol, Integer> leftDiagMap = new HashMap<>();
    private Map<Symbol, Integer> rightDiagMap = new HashMap<>();

    public Boolean checkWinner(Board board ,List<Move>moves){
    Move move=moves.getLast();
     int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Symbol symbol = move.getPlayer().getSymbol();

        // Left Diagonal
        if(row == col) {
            if(!leftDiagMap.containsKey(symbol)) {
                leftDiagMap.put(symbol, 0);
            }

            leftDiagMap.put(symbol, leftDiagMap.get(symbol) + 1);

            if(leftDiagMap.get(symbol) == board.getDimension()) {
                return true;
            }
        }

        // Right Diagonal
        if(row + col == board.getDimension() - 1) {
            if(!rightDiagMap.containsKey(symbol)) {
                rightDiagMap.put(symbol, 0);
            }

            rightDiagMap.put(symbol, rightDiagMap.get(symbol) + 1);

            return rightDiagMap.get(symbol) == board.getDimension();
        }

        return false;
    }
}
