package bowling.business;

import bowling.business.score.Scorer;
import bowling.business.throwmarker.ThrowMarker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BowlingGame {
    private Scorer scorer;
    private ThrowMarker throwMarker;

    public void registerFrame(String playerName, Integer pins) {
        this.throwMarker.markThrow(playerName, pins);
    }
}
