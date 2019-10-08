package bowling.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerCantPlayMoreException extends GameException {
    private final String playerName;

    @Override
    public void onError() {
        System.out.println("El jugador "+playerName+" no puede jugar mas");
        System.exit(1);
    }
}
