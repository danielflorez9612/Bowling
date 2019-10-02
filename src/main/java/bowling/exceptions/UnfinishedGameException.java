package bowling.exceptions;

public class UnfinishedGameException extends GameException {
    @Override
    public void onError() {
        System.out.println("this game hasn't over yet");
    }
}
