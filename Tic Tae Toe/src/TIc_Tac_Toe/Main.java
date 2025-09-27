package TIc_Tac_Toe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TIc_Tac_Toe.Controller.GameControler;
import TIc_Tac_Toe.Exception.IllegalMove;
import TIc_Tac_Toe.Exception.InvalidBotCount;
import TIc_Tac_Toe.Exception.InvalidPlayerCount;
import TIc_Tac_Toe.Model.Bot;
import TIc_Tac_Toe.Model.BotDiffcutyLevel;
import TIc_Tac_Toe.Model.Game;
import TIc_Tac_Toe.Model.GameStatus;
import TIc_Tac_Toe.Model.Player;
import TIc_Tac_Toe.Model.Symbol;

public class Main {
    public static void main(String[] args) throws InvalidBotCount, InvalidPlayerCount, IllegalMove {
        System.out.println("-------Welcome To Tic Tae Toe---------");
        GameControler gameControler = new GameControler();
        Scanner scanner= new Scanner(System.in);
        
       System.out.println("Enter the dimension of board");
        int dimension = scanner.nextInt();
         List<Player> players = new ArrayList<>();

         int maxPlayer=dimension-1;
         System.out.println("Max Player can enter in game is "+maxPlayer);
         System.out.println("want to add bot? y/n");

                String y_n=scanner.next();

         if(y_n.equals("y")){
          System.out.println("Name of the bot");
          String name_bot=scanner.next();
          System.out.println("Difficuty Level Easy/Medium/Hard");
          String BotLevel=scanner.next();
          System.out.println("Assign Bot Symbol");
          String BotSymbol=scanner.next();
  
         players.add(new Bot(name_bot,new Symbol(BotSymbol),BotDiffcutyLevel.valueOf(BotLevel)));
          maxPlayer--;
         }
         System.out.println("Max Player can enter in game is "+maxPlayer);
         for (int i = 0; i < maxPlayer; i++) {

                System.out.println("Enter the player name "+(i+1));
                String name=scanner.next();

                System.out.println("Assign  Symbol to "+ name);
                String Symbol=scanner.next();
                players.add(new Player(name,new Symbol(Symbol)));
             
         }




         
        Game game=gameControler.StartGame(dimension, players);

        while (game.getGameStatus()==GameStatus.IN_PROGRESS){
            gameControler.displayBoard(game);
          
                gameControler.makeMove(game);
        }
         game.displayBoard();
                System.out.println("Game Over");
        if(game.getGameStatus()==GameStatus.WINNER){
                System.out.println("Winner is "+game.getWinner().getName());
        }
        else{
                System.out.println("Game is Draw");
        }

        scanner.close();
        





}}



        

