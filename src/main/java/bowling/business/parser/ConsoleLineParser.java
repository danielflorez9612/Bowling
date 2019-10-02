package bowling.business.parser;

import lombok.Data;

@Data
public class ConsoleLineParser implements LineParser {
    private String playerName;
    private Integer pins;

    @Override
    public void onError(ValidationError err) {
        System.out.println(err.getError());
    }

}
