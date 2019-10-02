package bowling.business.throwmarker;

import bowling.exceptions.GameException;
import bowling.model.FinishedGame;

public interface ThrowMarker {
    void markThrow(String playerName, Integer pins) throws GameException;
    FinishedGame finishGame();
}
