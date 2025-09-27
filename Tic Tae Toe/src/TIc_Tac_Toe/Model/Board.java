package TIc_Tac_Toe.Model;

import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board( int dimension) {
        this.dimension = dimension;
        board = new java.util.ArrayList<>();
        for(int i=0;i<dimension;i++){
            board.add(new java.util.ArrayList<>());
            for(int j=0;j<dimension;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void displayBoard(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                if(board.get(i).get(j).isEmplty()){
                System.out.print("|   |");}
                else{
                    System.out.print("| "+board.get(i).get(j).player.getSymbol().getSymbol()+" |");
                }
            }
            System.out.println();
        }
    }
    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getDimension() {
        return dimension;
    }
  

    
}
