package TIc_Tac_Toe.Strategies.WinStrategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TIc_Tac_Toe.Model.Board;
import TIc_Tac_Toe.Model.Move;
import TIc_Tac_Toe.Model.Symbol;

public class RowStrategies implements Strategies {
    private Map<Integer,Map<Symbol,Integer>>RowMap=new HashMap<>();;

    public Boolean checkWinner(Board boad ,List<Move>moves){

        //.out.println("Checking Row Strategy...");
    Move LastMove=moves.getLast();

    if(LastMove==null){
        return false;
    }
    //int MaxCol=boad.getBoard().get(0).size();
    //.out.println("Last Move at row: "+LastMove.getCell().getRow()+" col: "+LastMove.getCell().getRow());
    if(RowMap.get(LastMove.getCell().getRow())==null){
        RowMap.put(LastMove.getCell().getRow(),new HashMap<>());
    }
 //.out.println("Row Map before updating: "+RowMap);

     Map<Symbol,Integer>movemap=RowMap.get(LastMove.getCell().getRow());

    Symbol curreSymbol=LastMove.getCell().getPlayer().getSymbol();
    
     if(movemap.get(curreSymbol) == null){
        movemap.put(curreSymbol,0);
     }
     
     //.out.println("Current Move Map before updating: "+movemap);
     movemap.put(curreSymbol,movemap.get(curreSymbol)+1);
     RowMap.put(LastMove.getCell().getRow(),movemap);
     //.out.println("Row Map after updating: "+RowMap);

     if(movemap.get(curreSymbol)==boad.getDimension()){
        return true;
     }
     System.out.println("Row Strategy did not find a winner.");
        return false;

    }
    
}
