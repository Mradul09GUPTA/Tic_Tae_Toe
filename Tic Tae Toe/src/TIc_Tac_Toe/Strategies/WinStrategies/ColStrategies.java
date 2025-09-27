package TIc_Tac_Toe.Strategies.WinStrategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TIc_Tac_Toe.Model.Board;
import TIc_Tac_Toe.Model.Move;
import TIc_Tac_Toe.Model.Symbol;

public class ColStrategies implements Strategies {
    
    private Map<Integer,Map<Symbol,Integer>>ColMap=new HashMap<>();;

    public Boolean checkWinner(Board boad ,List<Move>moves){
    Move LastMove=moves.getLast();

    if(LastMove==null){
        return false;
    }
    //int MaxCol=boad.getBoard().get(0).size();
    if(ColMap.get(LastMove.getCell().getCol())==null){
        ColMap.put(LastMove.getCell().getCol(),new HashMap<>());
    }

     Map<Symbol,Integer>movemap=ColMap.get(LastMove.getCell().getCol());

    Symbol curreSymbol=LastMove.getCell().getPlayer().getSymbol();

     if(movemap.get(curreSymbol) == null){
        movemap.put(curreSymbol,0);
     }
     
     movemap.put(curreSymbol,movemap.get(curreSymbol)+1);
     ColMap.put(LastMove.getCell().getCol(),movemap);
     if(movemap.get(curreSymbol)==boad.getDimension()){
        return true;
     }
     //.out.println("Col Strategy did not find a winner.");
        return false;

    }
    
}
