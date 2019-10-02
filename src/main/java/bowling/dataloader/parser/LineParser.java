package bowling.dataloader.parser;

import bowling.exceptions.GameException;
import bowling.exceptions.LineValidationException;

import java.util.Objects;

@FunctionalInterface
public interface LineParser {
    default ParsedLine parse(String line) throws GameException {
        ParsedLine parsedLine = new ParsedLine();
        String[] frameParts = line.split(" ");
        if (frameParts.length != 2) {
            throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_FORMAT, line));
        }
        parsedLine.setPlayerName(frameParts[0]);
        try {
            String pinString = frameParts[1];
            if (Objects.equals(pinString, "F")) {
                parsedLine.setPins(-1);
            } else {
                parsedLine.setPins(Integer.valueOf(pinString));
            }
            if (parsedLine.getPins() > 10 || (parsedLine.getPins() < 0 && !pinString.equals("F")) ) {
                throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_THROW, line));
            }
        } catch (NumberFormatException ignored) {
            throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_FORMAT, line));
        }
        return parsedLine;
    }
    void onError(ValidationError err);
}
