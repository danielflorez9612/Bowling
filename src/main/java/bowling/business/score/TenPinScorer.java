package bowling.business.score;

import bowling.model.FinishedGame;

public class TenPinScorer implements Scorer {
    @Override
    public FinishedGame score(FinishedGame finishedGame) {
        return finishedGame;
    }
}
