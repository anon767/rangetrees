import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalTest {

    @Test
    public void overlapsWith() {
        Interval i1 = new Interval(0,5);
        Interval i2 = new Interval(3,6);
        assertTrue(i1.overlapsWith(i2));
        assertEquals(i1.overlapsWith(i2),i2.overlapsWith(i1));
    }
}