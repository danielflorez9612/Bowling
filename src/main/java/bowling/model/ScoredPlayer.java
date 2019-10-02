package bowling.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
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

    public ScoredPlayer(Player player, Collection<ScoredFrame> newScores) {
        this.player = player;
        this.scores = new ArrayList<>(newScores);
    }
}
