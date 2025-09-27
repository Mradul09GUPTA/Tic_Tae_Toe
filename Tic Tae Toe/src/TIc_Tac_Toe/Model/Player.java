package TIc_Tac_Toe.Model;

import java.util.Scanner;

public class Player {
    private  static int id=0;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    public static Scanner scanner=new Scanner(System.in);
    public Player(String name, Symbol symbol) {
        id=id+1;
        this.name = name;
        this.symbol = symbol;
        playerType = PlayerType.Human;
    }
   
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Player.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){

            System.out.println("Enter the row ");
            int row=scanner.nextInt();
            System.out.println("Enter the column");
            int col=scanner.nextInt();
            Move move=new Move();
            Cell cell =board.getBoard().get(row).get(col);
            move.setCell(cell);
            move.setPlayer(this);
            return move;
    }


    

    
    



    
}
