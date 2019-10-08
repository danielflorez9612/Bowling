package bowling.exceptions;

public abstract class GameException extends Exception {
    public abstract void onError();
}
