package bowling.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private Scorer scorer;
    private ThrowMarker throwMarker;

    public void registerFrame(String playerName, Integer pins) {
        this.throwMarker.markThrow(playerName, pins);
    }
}
