package bowling.throwmarker;


import bowling.exceptions.GameException;
import org.junit.Test;


public class TenPinThrowMarkerTest {

    @Test(expected = GameException.class)
    public void markMoreThan10NotAllowed() throws GameException {
        TenPinThrowMarker tenPinThrowMarker = new TenPinThrowMarker();
        tenPinThrowMarker.markThrow("Mark", 11);
    }
}