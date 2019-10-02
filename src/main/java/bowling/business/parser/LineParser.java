package bowling.business.parser;

public interface LineParser {
    ValidationError parse(String line);
    String getPlayerName();
    Integer getPins();
    void onError(ValidationError err);
}
