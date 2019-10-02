package bowling.business.throwmarker;

import bowling.exceptions.GameException;
import bowling.exceptions.PlayerCantPlayMoreException;
import bowling.exceptions.UnfinishedGameException;
import bowling.model.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Data
public class TenPinThrowMarker implements ThrowMarker {
    private static final Integer MAX_THROWS = 11;
    private static final Integer STRIKE_SCORE = 10;
    private Set<PlayerGame> playerGames;

    public TenPinThrowMarker() {
        this.playerGames = new HashSet<>();
    }

    private Optional<PlayerGame> getPlayerGame(String playerName) {
        return playerGames.stream().filter(playerGame -> playerGame.getPlayer().getName().equals(playerName)).findFirst();
    }

    @Override
    public void markThrow(String playerName, Integer pins) throws GameException {
        Optional<PlayerGame> playerGame = getPlayerGame(playerName);
        if (playerGame.isPresent()) {
            playerGames.add(score(playerGame.get(), pins));
        } else {
            PlayerGame newGame = new PlayerGame(new Player(playerName));
            playerGames.add(score(newGame, pins));
        }
    }

    @Override
    public FinishedGame finishGame() throws GameException {
        if(this.playerGames.stream().anyMatch(playerGame -> playerGame.getFrameCounter()< MAX_THROWS)) {
            throw new UnfinishedGameException();
        }
        return new FinishedGame(this.playerGames);
    }

    private PlayerGame score(PlayerGame playerGame, Integer pins) throws GameException {
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
        if (playerGame.getFrameCounter() > MAX_THROWS && currentFrame.getTotalScore()<STRIKE_SCORE) {
            throw new PlayerCantPlayMoreException(playerGame.getPlayer().getName());
        }
        return playerGame;
    }
}
