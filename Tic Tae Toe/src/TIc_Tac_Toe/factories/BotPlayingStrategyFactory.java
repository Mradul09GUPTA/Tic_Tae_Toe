package TIc_Tac_Toe.factories;

import TIc_Tac_Toe.Model.BotDiffcutyLevel;
import TIc_Tac_Toe.Strategies.botPlayingStrategy.BotPlayingStrategy;
import TIc_Tac_Toe.Strategies.botPlayingStrategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDiffcutyLevel level) {
        return switch (level) {
            case Easy -> new EasyBotPlayingStrategy();
            default -> throw new IllegalArgumentException("Unexpected value: " + level);
        };
    }
}
