package bowling.throwmarker;


import bowling.exceptions.GameException;
import bowling.model.PlayerGame;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;


public class TenPinThrowMarkerTest {

    @Test(expected = GameException.class)
    public void markMoreThan10NotAllowed() throws GameException {
        TenPinThrowMarker tenPinThrowMarker = new TenPinThrowMarker();
        tenPinThrowMarker.markThrow("Mark", 11);
    }

    @Test
    public void throwFrameOk() throws GameException {
        TenPinThrowMarker tenPinThrowMarker = new TenPinThrowMarker();
        tenPinThrowMarker.markThrow("Mark", 2);
        tenPinThrowMarker.markThrow("Mark", 4);
        assertThat(tenPinThrowMarker.getPlayerGames(), hasSize(1));
        Optional<PlayerGame> playerGame = tenPinThrowMarker.getPlayerGames().stream().findFirst();
        assertTrue(playerGame.isPresent());
        assertEquals(1, playerGame.get().getFrameCounter());
        assertThat(playerGame.get().getFrames(), hasSize(1));
    }

    @Test
    public void throwFrameStrikesOk() throws GameException {
        TenPinThrowMarker tenPinThrowMarker = new TenPinThrowMarker();
        tenPinThrowMarker.markThrow("Mark", 10);
        tenPinThrowMarker.markThrow("Mark", 10);
        tenPinThrowMarker.markThrow("Mark", 10);
        assertThat(tenPinThrowMarker.getPlayerGames(), hasSize(1));
        Optional<PlayerGame> playerGame = tenPinThrowMarker.getPlayerGames().stream().findFirst();
        assertTrue(playerGame.isPresent());
        assertEquals(3, playerGame.get().getFrameCounter());
        assertThat(playerGame.get().getFrames(), hasSize(3));
    }

    @Test
    public void throwFrameMixedOk() throws GameException {
        TenPinThrowMarker tenPinThrowMarker = new TenPinThrowMarker();
        tenPinThrowMarker.markThrow("Mark", 2);
        tenPinThrowMarker.markThrow("Mark", 3);
        tenPinThrowMarker.markThrow("Mark", 4);
        assertThat(tenPinThrowMarker.getPlayerGames(), hasSize(1));
        Optional<PlayerGame> playerGame = tenPinThrowMarker.getPlayerGames().stream().findFirst();
        assertTrue(playerGame.isPresent());
        assertEquals(2, playerGame.get().getFrameCounter());
    }

    @Test
    public void severalPlayerThrow() throws GameException {
        TenPinThrowMarker tenPinThrowMarker = new TenPinThrowMarker();
        tenPinThrowMarker.markThrow("Mark", 10);
        tenPinThrowMarker.markThrow("John", 10);
        assertThat(tenPinThrowMarker.getPlayerGames(), hasSize(2));
    }
}