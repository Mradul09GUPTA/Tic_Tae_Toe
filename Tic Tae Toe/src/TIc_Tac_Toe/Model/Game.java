package TIc_Tac_Toe.Model;

import java.util.ArrayList;
import java.util.List;


import TIc_Tac_Toe.Exception.IllegalMove;
import TIc_Tac_Toe.Exception.InvalidBotCount;
import TIc_Tac_Toe.Exception.InvalidPlayerCount;
 import TIc_Tac_Toe.Strategies.WinStrategies.ColStrategies;
 import TIc_Tac_Toe.Strategies.WinStrategies.DiagonalStrategies;
 import TIc_Tac_Toe.Strategies.WinStrategies.RowStrategies;
 import TIc_Tac_Toe.Strategies.WinStrategies.Strategies;

public class Game {
    private Board board;
    private List<Player> players;
    private int dimension;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    //private int nextPlayerIndex;
    private Player winner;
    private List<Move> moves;
    private List<Strategies>strategies;

    private Game(int dimension, List<Player> players) {
        this.dimension = dimension;
        this.players = players;
        this.board = new Board(dimension);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;

        this.winner = null;
        moves = new java.util.ArrayList<>();
         strategies=new ArrayList<>();
         strategies.add(new RowStrategies());
         strategies.add(new ColStrategies());
         strategies.add(new DiagonalStrategies());
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getDimension() {
        return dimension;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }
    
    public void displayBoard(){
        board.displayBoard();
    }   
    
    public boolean validatemove(Move move) throws IllegalMove{

        Cell cell=move.getCell();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        // dimension == 3
        // rows = 0, 1, 2
        // cols = 0, 1, 2
        if(row < 0 ||
                row >= this.board.getDimension() ||
                col < 0 ||
                col >= this.board.getDimension()) {
            return false;
        }
        if(cell.isEmplty()){
            cell.setPlayer(move.getPlayer());
            cell.setCellState(CellState.FILLED);
            return true;
        }
        else{
         throw new IllegalMove("Cell is already occupied");
            
        }
    }

    public void makeMove() throws IllegalMove{
        Player currentPlayer=players.get(nextPlayerIndex);
        System.out.println("This is a "+currentPlayer.getName()+"'s turn");
        
        Move move=currentPlayer.makeMove(board);

        System.out.println("Player "+currentPlayer.getName()+" has placed "+currentPlayer.getSymbol()+" at row "+move.getCell().getRow()+" and column "+move.getCell().getCol());
         if(!validatemove(move)){
            throw new IllegalMove("This move is not valid");
         }

        

        moves.add(move);
        // Strategies 
        //System.out.println("Checking for winner...");
        for (Strategies s :strategies ) {
              if(s.checkWinner(board,moves)){
                this.winner=currentPlayer;
                this.gameStatus=GameStatus.WINNER;
                return ;
              }

        }
            if(moves.size()==dimension*dimension){
                this.gameStatus=GameStatus.DRAW;
                return ;
            }



           nextPlayerIndex=(nextPlayerIndex+1)%players.size();



    }
    public void undo() {
        // implement undo
        // Check if we can even undo?
        if(moves.isEmpty()) {
            System.out.println("No moves to undo");
            return;
        }

        // Get the last move
        Move lastMove = moves.remove(moves.size()-1);

        // Reset the cell on the board
        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        // Update the next player index to the previous player
        nextPlayerIndex = (nextPlayerIndex - 1 + players.size()) % players.size();

        System.out.println("Last move is undone. It's now " + players.get(nextPlayerIndex).getName() + "'s turn");

        // 0 1 2 3 4 5 => 3 + 6 = 9 % 6 = 3
        // Alok -> Shikha
    }
    
    
    public static GameBuilder toBuilder(){
        System.out.println("Builder pattern initiated");
        return new GameBuilder();
    }


    public static class GameBuilder{

        private int dimension;
        private List<Player> players;
       
        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public void validatePlayers(List<Player>player,int dimension) throws InvalidBotCount, InvalidPlayerCount{
            int noofBot=0;
           for (Player player2 : player) {
            if(player2.getPlayerType()==PlayerType.Bot){
                noofBot++;
            }  
           }
           if(noofBot>1){
            throw new InvalidBotCount("More than one bot is not allowed");
           }
           if(player.size()>dimension-1){
            throw new InvalidPlayerCount("More than two players are not allowed");
           }

        }


        
        public Game build() throws InvalidBotCount, InvalidPlayerCount{
            validatePlayers(this.players,this.dimension);
            return new Game(dimension,players);
        }

    }



    
}
