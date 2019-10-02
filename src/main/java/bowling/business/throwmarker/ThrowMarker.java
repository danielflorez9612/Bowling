package bowling.business.throwmarker;

import bowling.exceptions.GameException;

@FunctionalInterface
public interface ThrowMarker {
    void markThrow(String playerName, Integer pins) throws GameException;
}
