package bowling;

import bowling.dataloader.parser.LineParser;
import bowling.dataloader.parser.ParsedLine;
import bowling.exceptions.GameException;
import bowling.model.FinishedGame;
import bowling.printer.GamePrinter;
import bowling.score.Scorer;
import bowling.throwmarker.ThrowMarker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BowlingGame {
    private Scorer scorer;
    private ThrowMarker throwMarker;
    private LineParser lineParser;
    private GamePrinter gamePrinter;

    public void registerFrame(String line) throws GameException {
        ParsedLine parsedLine = lineParser.parse(line);
        this.throwMarker.markThrow(parsedLine.getPlayerName(), parsedLine.getPins());
    }

    public void printScore()  {
        FinishedGame finishedGame = this.scorer.score(throwMarker.finishGame());
        gamePrinter.print(finishedGame);
    }
}
