package bowling;

import bowling.business.dataloader.ConsoleInputLoader;
import bowling.business.dataloader.InputLoader;
import bowling.business.score.Scorer;
import bowling.business.score.TenPinScorer;
import bowling.business.throwmarker.TenPinThrowMarker;
import bowling.business.throwmarker.ThrowMarker;
import bowling.business.BowlingGame;
import bowling.business.parser.ConsoleLineParser;
import bowling.business.parser.LineParser;
import bowling.business.parser.ValidationError;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Scorer scorer = new TenPinScorer();
        ThrowMarker marker = new TenPinThrowMarker();
        InputLoader inputLoader = new ConsoleInputLoader();
        BowlingGame tenPinGame = new BowlingGame(scorer, marker);
        while (inputLoader.hasNextInput()) {
            String line = inputLoader.getLine();
            if(Objects.isNull(line)) {
                break;
            }
            LineParser lineParser = new ConsoleLineParser();
            ValidationError err = lineParser.parse(line);
            if (Objects.nonNull(err)) {
                lineParser.onError();
            } else {
                tenPinGame.registerFrame(lineParser.getPlayerName(), lineParser.getPins());
            }
        }
        inputLoader.finish();
    }
}
