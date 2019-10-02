package bowling.business;

import bowling.model.ScoredGame;

public interface Scorer {
    ScoredGame score(Game game);
}
