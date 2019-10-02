package bowling.business.parser;

import lombok.Data;

@Data
public class ConsoleLineParser implements LineParser {
    private String playerName;
    private Integer pins;

    @Override
    public ValidationError parse(String line) {
        String[] frameParts = line.split(" ");
        if (frameParts.length != 2) {
            return new ValidationError(ValidationErrorCatalog.INVALID_FORMAT);
        }
        this.playerName = frameParts[0];
        try {
            this.pins = Integer.valueOf(frameParts[1]);
            if (this.pins > 10 || this.pins < 0) {
                return new ValidationError(ValidationErrorCatalog.INVALID_THROW);
            }
        } catch (NumberFormatException ignored) {
            return new ValidationError(ValidationErrorCatalog.INVALID_FORMAT);
        }
        return null;
    }

    @Override
    public void onError(ValidationError err) {
        System.out.println(err.getError());
    }

}
