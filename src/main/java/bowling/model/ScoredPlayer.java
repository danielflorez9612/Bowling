package bowling.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ScoredPlayer {
    private Player player;
    private List<ScoredFrame> scores;

    public ScoredPlayer(PlayerGame playerGame) {
        this.player = playerGame.getPlayer();
        this.scores = playerGame.getFrames().stream().map(ScoredFrame::new).collect(Collectors.toList());
    }
}
