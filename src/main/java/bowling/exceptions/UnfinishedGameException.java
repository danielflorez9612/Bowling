package bowling.exceptions;

public class UnfinishedGameException extends GameException {
    @Override
    public void onError() {
        System.out.println("El juego aún no ha terminado");
    }
}
