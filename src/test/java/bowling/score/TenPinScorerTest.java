package bowling.score;

import bowling.model.FinishedGame;
import bowling.model.Frame;
import bowling.model.Player;
import bowling.model.PlayerGame;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TenPinScorerTest {

    @Test
    public void testScoreFillOk() {
        TenPinScorer scorer = new TenPinScorer();
        Player daniel = new Player("Daniel");
        List<PlayerGame> games = Arrays.asList(
                new PlayerGame(daniel)
                        .addFrame(new Frame(1, 9, 1))
                        .addFrame(new Frame(2, -1, 1))
                        .addFrame(new Frame(3, 1, -1))
                        .addFrame(new Frame(4, 3, 2))
                        .addFrame(new Frame(5, 10, null))
                        .addFrame(new Frame(6, 10, null))
                        .addFrame(new Frame(7, 2, 3))
                        .addFrame(new Frame(8, 2, 2))
        );
        FinishedGame preScore = new FinishedGame(games);
        assertThat(preScore.getScoredPlayers(), everyItem(hasProperty("scores", everyItem(hasProperty("score", nullValue())))));
        FinishedGame game = scorer.score(preScore);
        assertThat(game.getScoredPlayers(), everyItem(hasProperty("scores", everyItem(hasProperty("score", notNullValue())))));
    }
}