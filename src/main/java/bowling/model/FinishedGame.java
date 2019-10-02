package bowling.model;

import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class FinishedGame {
    private List<ScoredPlayer> scoredPlayers;

    public FinishedGame(List<ScoredPlayer> scoredPlayers) {
        this.scoredPlayers = scoredPlayers;
    }

    public FinishedGame(Collection<PlayerGame> playerGames) {
        this.scoredPlayers = playerGames.stream().map(ScoredPlayer::new).collect(Collectors.toList());
    }

}
