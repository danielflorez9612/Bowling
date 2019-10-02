package bowling.business.parser;

import lombok.Data;

@Data
public class ConsoleLineParser implements LineParser {
    @Override
    public void onError(ValidationError err) {
        System.out.println(err.getError()+" ("+err.getThrowString()+")");
    }

}
