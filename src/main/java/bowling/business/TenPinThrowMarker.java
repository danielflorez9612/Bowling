package bowling.business;

import bowling.model.Frame;
import bowling.model.Player;
import bowling.model.PlayerGame;
import lombok.Data;

import java.util.*;

@Data
public class TenPinThrowMarker implements ThrowMarker {
    private static final Integer STRIKE_SCORE = 10;
    private Set<PlayerGame> playerGames;

    public TenPinThrowMarker() {
        this.playerGames = new HashSet<>();
    }

    private Optional<PlayerGame> getPlayerGame(String playerName) {
        return playerGames.stream().filter(playerGame -> playerGame.getPlayer().getName().equals(playerName)).findFirst();
    }

    @Override
    public void markThrow(String playerName, Integer pins) {
        Optional<PlayerGame> playerGame = getPlayerGame(playerName);
        if (playerGame.isPresent()) {
            playerGames.add(score(playerGame.get(), pins));
        } else {
            PlayerGame newGame = new PlayerGame(new Player(playerName));
            playerGames.add(score(newGame, pins));
        }
        System.out.println(this.playerGames);
    }

    private PlayerGame score(PlayerGame playerGame, Integer pins) {
        Frame currentFrame = playerGame.getLastFrame().orElse(new Frame(0));
        if (Objects.isNull(currentFrame.getFirstBall())) {
            currentFrame.setFirstBall(pins);
        } else if (Objects.nonNull(currentFrame.getSecondBall()) || currentFrame.getFirstBall().equals(STRIKE_SCORE)) {
            currentFrame = new Frame(currentFrame.getFrameNumber() + 1);
            currentFrame.setFirstBall(pins);
        } else {
            currentFrame.setSecondBall(pins);
        }
        playerGame.addFrame(currentFrame);
        return playerGame;
    }
}
