package bowling.business.parser;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ValidationError {
    private ValidationErrorCatalog error;
}
