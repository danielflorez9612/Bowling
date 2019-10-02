package bowling.dataloader.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationError {
    private ValidationErrorCatalog error;
    private String throwString;
}
