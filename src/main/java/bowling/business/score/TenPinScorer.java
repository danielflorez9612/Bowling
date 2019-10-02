package bowling.business.score;

import bowling.model.FinishedGame;
import bowling.model.Frame;
import bowling.model.ScoredFrame;
import bowling.model.ScoredPlayer;

import java.util.*;
import java.util.stream.Collectors;

public class TenPinScorer implements Scorer {

    private static ScoredPlayer score(ScoredPlayer player) {
        List<ScoredFrame> scores = player.getScores();
        Deque<ScoredFrame> newScores = new LinkedList<>();
        int size = scores.size();
        for (int i = 0; i < size; i++) {
            ScoredFrame currentFrame = scores.get(i);
            ScoredFrame scoredFrame = new ScoredFrame(currentFrame.getFrame());
            int score = currentFrame.totalScore();
            if (currentFrame.isStrike()) {
                score += next(2, scores, i);
            } else if (currentFrame.isSpare()) {
                score += next(1, scores, i);
            }
            if (!newScores.isEmpty()) {
                score += newScores.getLast().getScore();
            }
            scoredFrame.setScore(score);
            newScores.addLast(scoredFrame);
        }
        return new ScoredPlayer(player.getPlayer(), newScores);
    }

    private static Integer next(int quantity, List<ScoredFrame> scores, int i) {
        int newI = i + 1;
        if (newI >= scores.size()) {
            return 0;
        }
        Frame nextFrame = scores.get(newI).getFrame();
        if (quantity == 1) {
            return nextFrame.getFirstBall() < 0 ? 0 : nextFrame.getFirstBall();
        }
        if (quantity == 2) {
            int counter = nextFrame.getFirstBall();
            if (Objects.isNull(nextFrame.getSecondBall())) {
                counter += next(1, scores, newI);
            } else {
                counter += nextFrame.getSecondBall() < 0 ? 0 : nextFrame.getSecondBall();
            }
            return counter;
        }
        return next(2, scores, i);
    }

    @Override
    public FinishedGame score(FinishedGame finishedGame) {
        return new FinishedGame(finishedGame.getScoredPlayers().stream().map(TenPinScorer::score).collect(Collectors.toList()));
    }
}
