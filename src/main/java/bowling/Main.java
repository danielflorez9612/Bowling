package bowling;

import bowling.business.Scorer;
import bowling.business.TenPinScorer;
import bowling.business.TenPinThrowMarker;
import bowling.business.ThrowMarker;
import bowling.business.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scorer scorer = new TenPinScorer();
        ThrowMarker marker = new TenPinThrowMarker();
        Game tenPinGame = new Game(scorer, marker);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] frameParts = scanner.nextLine().split(" ");
            tenPinGame.registerFrame(frameParts[0], Integer.valueOf(frameParts[1]));
        }
        scanner.close();

    }
}
