package bowling.dataloader.parser;

public class DefaultLineParser implements LineParser {
    @Override
    public void onError(ValidationError err) {
        System.out.println(err.getError()+" ("+err.getThrowString()+")");
    }

}
