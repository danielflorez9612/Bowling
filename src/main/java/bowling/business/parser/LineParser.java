package bowling.business.parser;

import bowling.exceptions.GameException;
import bowling.exceptions.LineValidationException;

@FunctionalInterface
public interface LineParser {
    default ParsedLine parse(String line) throws GameException {
        ParsedLine parsedLine = new ParsedLine();
        String[] frameParts = line.split(" ");
        if (frameParts.length != 2) {
            throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_FORMAT));
        }
        parsedLine.setPlayerName(frameParts[0]);
        try {
            parsedLine.setPins(Integer.valueOf(frameParts[1]));
            if (parsedLine.getPins() > 10 || parsedLine.getPins() < 0) {
                throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_THROW));
            }
        } catch (NumberFormatException ignored) {
            throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_FORMAT));
        }
        return parsedLine;
    }
    void onError(ValidationError err);
}
