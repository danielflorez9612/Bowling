package bowling.business.printer;

import bowling.model.FinishedGame;
import bowling.model.ScoredFrame;
import bowling.model.ScoredPlayer;

import java.util.Objects;

public class SimpleGamePrinter implements GamePrinter {

    private static void printFrame(ScoredFrame scoredFrame) {
        if (!Objects.nonNull(scoredFrame.getFrame().getSecondBall())) {
            // Strike
            System.out.print("\t");
            printBall(scoredFrame.getFrame().getFirstBall(), false);
        } else {
            if (scoredFrame.getFrame().getFirstBall() + scoredFrame.getFrame().getSecondBall() == 10) {
                // Spare
                printBall(scoredFrame.getFrame().getFirstBall(), true);
                System.out.print("\t/");
            } else {
                // Normal
                printBall(scoredFrame.getFrame().getFirstBall(), true);
                printBall(scoredFrame.getFrame().getSecondBall(), true);
            }
        }
    }

    private static void printBall(Integer ball, boolean printZero) {
        String ballRepresentation;
        if (ball.equals(0) && !printZero) {
            ballRepresentation = "";
        } else if (ball.equals(10)) {
            ballRepresentation = "X";
        } else if (ball.equals(-1)) {
            ballRepresentation = "F";
        } else {
            ballRepresentation = String.valueOf(ball);
        }
        System.out.print("\t" + ballRepresentation);
    }

    private void printScoredPlayer(ScoredPlayer scoredPlayer) {
        System.out.println(scoredPlayer.getPlayer().getName());
        System.out.print("Pinfalls");
        scoredPlayer.getScores().forEach(SimpleGamePrinter::printFrame);
        System.out.println();
        System.out.print("Score");
        scoredPlayer.getScores().stream().limit(10).forEach(this::printScore);
        System.out.println();
    }

    private void printScore(ScoredFrame scoredFrame) {
        System.out.print("\t\t" + scoredFrame.getScore());
    }

    @Override
    public void print(FinishedGame finishedGame) {
        System.out.println("Frame\t\t1\t\t2\t\t3\t\t5\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        finishedGame.getScoredPlayers().forEach(this::printScoredPlayer);
    }
}
