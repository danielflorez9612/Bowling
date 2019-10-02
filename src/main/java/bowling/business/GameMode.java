package bowling.business;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameMode {
    TEN_PIN(10, 10);
    private int maxThrows;
    private int strikeScore;
}
