package bowling.business.throwmarker;

import bowling.business.GameMode;
import bowling.exceptions.GameException;
import bowling.exceptions.PlayerCantPlayMoreException;
import bowling.model.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Data
public class TenPinThrowMarker implements ThrowMarker {
    private int maxThrows;
    private int strikeScore;
    private Set<PlayerGame> playerGames;

    public TenPinThrowMarker() {
        this.maxThrows = GameMode.TEN_PIN.getMaxThrows();
        this.strikeScore = GameMode.TEN_PIN.getStrikeScore();
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
    public FinishedGame finishGame() {
        return new FinishedGame(this.playerGames);
    }

    private PlayerGame score(PlayerGame playerGame, Integer pins) throws GameException {
        Frame currentFrame = playerGame.getLastFrame().orElse(new Frame(1));
        if (Objects.isNull(currentFrame.getFirstBall())) {
            currentFrame.setFirstBall(pins);
        } else if (Objects.nonNull(currentFrame.getSecondBall()) || currentFrame.getFirstBall().equals(getStrikeScore())) {
            currentFrame = new Frame(currentFrame.getFrameNumber() + 1);
            currentFrame.setFirstBall(pins);
        } else {
            currentFrame.setSecondBall(pins);
        }
        playerGame.addFrame(currentFrame);
        if (playerGame.getFrameCounter() > getMaxThrows() && currentFrame.getTotalScore() < getMaxThrows()) {
            throw new PlayerCantPlayMoreException(playerGame.getPlayer().getName());
        }
        return playerGame;
    }
}
