package bowling.business.throwmarker;

@FunctionalInterface
public interface ThrowMarker {
    void markThrow(String playerName, Integer pins);
}
