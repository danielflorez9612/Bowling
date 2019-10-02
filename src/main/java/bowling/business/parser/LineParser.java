package bowling.business.parser;

public interface LineParser {
    default ValidationError parse(String line) {
        String[] frameParts = line.split(" ");
        if (frameParts.length != 2) {
            return new ValidationError(ValidationErrorCatalog.INVALID_FORMAT);
        }
        setPlayerName(frameParts[0]);
        try {
            setPins(Integer.valueOf(frameParts[1]));
            if (getPins() > 10 || getPins() < 0) {
                return new ValidationError(ValidationErrorCatalog.INVALID_THROW);
            }
        } catch (NumberFormatException ignored) {
            return new ValidationError(ValidationErrorCatalog.INVALID_FORMAT);
        }
        return null;
    }
    String getPlayerName();

    void setPlayerName(String pN);
    Integer getPins();

    void setPins(Integer pins);
    void onError(ValidationError err);
}
