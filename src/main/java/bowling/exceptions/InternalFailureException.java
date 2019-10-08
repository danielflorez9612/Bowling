package bowling.exceptions;

public class InternalFailureException extends GameException {
    @Override
    public void onError() {
        System.out.println("Invalid state of the game (contact a programmer)");
    }
}
