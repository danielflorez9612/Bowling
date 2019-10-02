package bowling.business;

@FunctionalInterface
public interface ThrowMarker {
    void markThrow(String playerName, Integer pins);
}
