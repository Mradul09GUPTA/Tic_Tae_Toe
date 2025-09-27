package TIc_Tac_Toe.Model;

import TIc_Tac_Toe.Strategies.botPlayingStrategy.BotPlayingStrategy;
import TIc_Tac_Toe.factories.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BotDiffcutyLevel botDiffcutyLevel;

    public Bot(String name, Symbol symbol, BotDiffcutyLevel botDiffcutyLevel) {
        super(name, symbol);
        this.botDiffcutyLevel = botDiffcutyLevel;
        this.setPlayerType(PlayerType.Bot);
    }
    public BotDiffcutyLevel getBotDiffcutyLevel() {
        return botDiffcutyLevel;
    }
    
    public Move makeMove(Board board) {
       //BotPlayingStrategyFactory botPlayingStrategyFactory=new BotPlayingStrategyFactory();
        
       //getBotPlayingStrategyyFactory botPlayingStrategyFactory = new BotPlayingStrategyFactory();
       BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(this.botDiffcutyLevel);
       return botPlayingStrategy.makeMove(board, this);
    }
   
    
}
