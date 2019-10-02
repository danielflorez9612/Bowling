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
import bowling.exceptions.GameException;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Scorer scorer = new TenPinScorer();
        ThrowMarker marker = new TenPinThrowMarker();
        InputLoader inputLoader = new ConsoleInputLoader();
        LineParser lineParser = new ConsoleLineParser();
        BowlingGame tenPinGame = new BowlingGame(scorer, marker, lineParser);
        while (inputLoader.hasNextInput()) {
            try {
                String line = inputLoader.getLine();
                if(Objects.isNull(line)) {
                    break;
                }
                tenPinGame.registerFrame(line);
            } catch (GameException e) {
                e.onError();
            }
        }
        try {
            tenPinGame.printScore();
        } catch (GameException e) {
            e.onError();
        }
        inputLoader.finish();
    }
}
