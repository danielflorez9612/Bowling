package bowling.exceptions;

import bowling.business.parser.LineParser;
import bowling.business.parser.ValidationError;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LineValidationException extends GameException{

    private final transient LineParser parser;
    private final transient ValidationError validationError;

    @Override
    public void onError() {
        parser.onError(validationError);
    }
}
