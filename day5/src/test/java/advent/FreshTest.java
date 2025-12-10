package advent;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class FreshTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerExample1Correctly() {
        FreshCheck fcheck = new FreshCheck();
        fcheck.setFresh(3, 5);
        fcheck.setFresh(10, 14);
        fcheck.setFresh(16, 20);
        fcheck.setFresh(12, 18);

        assertTrue(!fcheck.isFresh(1));
        assertTrue(fcheck.isFresh(5));
        assertTrue(!fcheck.isFresh(8));
        assertTrue(fcheck.isFresh(11));
        assertTrue(fcheck.isFresh(17));
        assertTrue(!fcheck.isFresh(32));
    }
}
