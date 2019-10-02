package bowling.dataloader.parser;

import bowling.exceptions.GameException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultLineParserTest {
    @Test
    public void testParseOk() throws GameException {
        DefaultLineParser parser = new DefaultLineParser();
        ParsedLine parse = parser.parse("Daniel 10");
        assertEquals(new Integer(10), parse.getPins());
        assertEquals("Daniel", parse.getPlayerName());
    }

    @Test(expected = GameException.class)
    public void testParseLessPins() throws GameException {
        DefaultLineParser parser = new DefaultLineParser();
        ParsedLine parse = parser.parse("Daniel -20");
    }

    @Test(expected = GameException.class)
    public void testParseMorePins() throws GameException {
        DefaultLineParser parser = new DefaultLineParser();
        ParsedLine parse = parser.parse("Daniel 11");
    }

    @Test
    public void testParseOkFailure() throws GameException {
        DefaultLineParser parser = new DefaultLineParser();
        ParsedLine parse = parser.parse("Daniel F");
        assertEquals(new Integer(-1), parse.getPins());
    }

    @Test(expected = GameException.class)
    public void testParseErrorPins() throws GameException {
        DefaultLineParser parser = new DefaultLineParser();
        parser.parse("Daniel D");
    }

    @Test(expected = GameException.class)
    public void testParseErrorFormat() throws GameException {
        DefaultLineParser parser = new DefaultLineParser();
        parser.parse("Daniel 10 10");
    }
}