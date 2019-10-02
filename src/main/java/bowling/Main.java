package bowling;

import bowling.business.dataloader.ConsoleInputLoader;
import bowling.business.dataloader.InputLoader;
import bowling.business.score.Scorer;
import bowling.business.score.TenPinScorer;
import bowling.business.throwmarker.TenPinThrowMarker;
import bowling.business.throwmarker.ThrowMarker;
import bowling.business.BowlingGame;

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
            String[] frameParts = line.split(" ");
            tenPinGame.registerFrame(frameParts[0], Integer.valueOf(frameParts[1]));
        }
        inputLoader.finish();
    }
}
