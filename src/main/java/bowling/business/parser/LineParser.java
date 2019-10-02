package bowling.business.parser;

import bowling.exceptions.GameException;
import bowling.exceptions.LineValidationException;

import java.io.Serializable;

public interface LineParser {
    default void parse(String line) throws GameException {
        String[] frameParts = line.split(" ");
        if (frameParts.length != 2) {
            throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_FORMAT));
        }
        setPlayerName(frameParts[0]);
        try {
            setPins(Integer.valueOf(frameParts[1]));
            if (getPins() > 10 || getPins() < 0) {
                throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_THROW));
            }
        } catch (NumberFormatException ignored) {
            throw new LineValidationException(this, new ValidationError(ValidationErrorCatalog.INVALID_FORMAT));
        }
    }
    String getPlayerName();

    void setPlayerName(String pN);
    Integer getPins();

    void setPins(Integer pins);
    void onError(ValidationError err);
}
