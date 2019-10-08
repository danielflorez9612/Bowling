package bowling;

import bowling.dataloader.ConsoleInputLoader;
import bowling.dataloader.InputLoader;
import bowling.printer.GamePrinter;
import bowling.printer.ConsoleGamePrinter;
import bowling.score.Scorer;
import bowling.score.TenPinScorer;
import bowling.throwmarker.TenPinThrowMarker;
import bowling.throwmarker.ThrowMarker;
import bowling.dataloader.parser.DefaultLineParser;
import bowling.dataloader.parser.LineParser;
import bowling.exceptions.GameException;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Scorer scorer = new TenPinScorer();
        ThrowMarker marker = new TenPinThrowMarker();
        InputLoader inputLoader = new ConsoleInputLoader();
        LineParser lineParser = new DefaultLineParser();
        GamePrinter gamePrinter = new ConsoleGamePrinter(GameMode.TEN_PIN);
        BowlingGame tenPinGame = new BowlingGame(scorer, marker, lineParser, gamePrinter);
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
        tenPinGame.printScore();
        inputLoader.finish();
    }
}
