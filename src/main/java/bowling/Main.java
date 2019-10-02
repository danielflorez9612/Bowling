package bowling;

import bowling.business.GameMode;
import bowling.business.dataloader.ConsoleInputLoader;
import bowling.business.dataloader.InputLoader;
import bowling.business.printer.GamePrinter;
import bowling.business.printer.ConsoleGamePrinter;
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
