package bowling.printer;

import bowling.GameMode;
import bowling.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.fail;

public class ConsoleGamePrinterTest {
    @Test
    public void testPrinterPrintsWithoutError() {
        ConsoleGamePrinter printer = new ConsoleGamePrinter(GameMode.TEN_PIN);
        try {
            ArrayList<ScoredPlayer> scoredPlayers = new ArrayList<>();
            scoredPlayers.add(new ScoredPlayer(new Player("Daniel"), Arrays.asList(new ScoredFrame(new Frame(1, 2, 3)), new ScoredFrame(new Frame(2, 10, null)), new ScoredFrame(new Frame(3, 2, 3)), new ScoredFrame(new Frame(4, 2, 8)))));
            printer.print(new FinishedGame(scoredPlayers));
        } catch (Exception e) {
            fail();
        }
    }
}