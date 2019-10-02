package bowling.dataloader;

public interface InputLoader {
    boolean hasNextInput();

    String getLine();

    void finish();
}
