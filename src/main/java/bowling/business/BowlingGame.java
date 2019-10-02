package bowling.business;

import bowling.business.parser.LineParser;
import bowling.business.parser.ParsedLine;
import bowling.business.score.Scorer;
import bowling.business.throwmarker.ThrowMarker;
import bowling.exceptions.GameException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BowlingGame {
    private Scorer scorer;
    private ThrowMarker throwMarker;
    private LineParser lineParser;

    public void registerFrame(String line) throws GameException {
        ParsedLine parsedLine = lineParser.parse(line);
        this.throwMarker.markThrow(parsedLine.getPlayerName(), parsedLine.getPins());
    }


    }
}
