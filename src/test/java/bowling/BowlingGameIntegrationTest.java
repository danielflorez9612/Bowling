package bowling;

import bowling.dataloader.parser.DefaultLineParser;
import bowling.dataloader.parser.LineParser;
import bowling.printer.ConsoleGamePrinter;
import bowling.printer.GamePrinter;
import bowling.score.Scorer;
import bowling.score.TenPinScorer;
import bowling.throwmarker.TenPinThrowMarker;
import bowling.throwmarker.ThrowMarker;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameIntegrationTest {

    private BowlingGame bowlingGame;

    @Before
    public void setup() {
        Scorer scorer = new TenPinScorer();
        ThrowMarker marker = new TenPinThrowMarker();
        LineParser lineParser = new DefaultLineParser();
        GamePrinter gamePrinter = new ConsoleGamePrinter(GameMode.TEN_PIN);
        this.bowlingGame = new BowlingGame(scorer, marker, lineParser, gamePrinter);
    }

    @Test
    public void testTwoPlayers() {

    }

    @Test
    public void testPerfectGame() {

    }

    @Test
    public void testZeroGame() {

    }
}