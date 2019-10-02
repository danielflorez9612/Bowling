package bowling.dataloader.parser;

import lombok.Data;

@Data
public class DefaultLineParser implements LineParser {
    @Override
    public void onError(ValidationError err) {
        System.out.println(err.getError()+" ("+err.getThrowString()+")");
    }

}
