package bowling.exceptions;

import bowling.dataloader.parser.LineParser;
import bowling.dataloader.parser.ValidationError;
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
