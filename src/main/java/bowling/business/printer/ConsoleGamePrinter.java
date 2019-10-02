package bowling.business.printer;

import bowling.business.GameMode;
import bowling.model.FinishedGame;
import bowling.model.ScoredFrame;
import bowling.model.ScoredPlayer;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class ConsoleGamePrinter implements GamePrinter {
    private static final String SEPARATOR = "\t";
    private GameMode gameMode;

    private static void printScore(ScoredFrame scoredFrame) {
        System.out.print(SEPARATOR + SEPARATOR + scoredFrame.getScore());
    }

    private void printFrame(ScoredFrame scoredFrame) {
        if (!Objects.nonNull(scoredFrame.getFrame().getSecondBall())) {
            // Strike
            System.out.print(SEPARATOR);
            printBall(scoredFrame.getFrame().getFirstBall(), false);
        } else {
            if (scoredFrame.getFrame().getFirstBall() + scoredFrame.getFrame().getSecondBall() == this.gameMode.getMaxThrows()) {
                // Spare
                printBall(scoredFrame.getFrame().getFirstBall(), true);
                System.out.print(SEPARATOR + "/");
            } else {
                // Normal
                printBall(scoredFrame.getFrame().getFirstBall(), true);
                printBall(scoredFrame.getFrame().getSecondBall(), true);
            }
        }
    }

    private void printBall(Integer ball, boolean printZero) {
        String ballRepresentation;
        if (ball.equals(0) && !printZero) {
            ballRepresentation = "";
        } else if (ball.equals(gameMode.getStrikeScore())) {
            ballRepresentation = "X";
        } else if (ball.equals(-1)) {
            ballRepresentation = "F";
        } else {
            ballRepresentation = String.valueOf(ball);
        }
        System.out.print(SEPARATOR + ballRepresentation);
    }

    private void printScoredPlayer(ScoredPlayer scoredPlayer) {
        System.out.println(scoredPlayer.getPlayer().getName());
        System.out.print("Pinfalls");
        scoredPlayer.getScores().forEach(this::printFrame);
        System.out.println();
        System.out.print("Score");
        scoredPlayer.getScores().stream().limit(10).forEach(ConsoleGamePrinter::printScore);
        System.out.println();
    }

    @Override
    public void print(FinishedGame finishedGame) {
        this.printFrames();
        finishedGame.getScoredPlayers().forEach(this::printScoredPlayer);
    }

    private void printFrames() {
        System.out.print("Frame" + SEPARATOR);
        for (int i = 0; i < gameMode.getMaxThrows(); i++) {
            System.out.print(SEPARATOR + (i + 1));
        }
        System.out.println();
    }
}
