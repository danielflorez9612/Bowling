package bowling.business.score;

import bowling.model.FinishedGame;

@FunctionalInterface
public interface Scorer {
    FinishedGame score(FinishedGame bowlingGame);
}
