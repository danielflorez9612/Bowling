package bowling.business.score;

import bowling.business.BowlingGame;
import bowling.model.ScoredGame;

public interface Scorer {
    ScoredGame score(BowlingGame bowlingGame);
}
