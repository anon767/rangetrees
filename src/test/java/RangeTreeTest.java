import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

public class RangeTreeTest {
    RangeTree rangetree;

    @Before
    public void setup() {
        rangetree = new RangeTree();
        int[] nums = {15, 20, 10, 30, 17, 19, 5, 20, 12, 15, 30, 40};
        for (int i = 0; i < nums.length; i += 2) {
            rangetree.insert(new Interval(nums[i], nums[i + 1]));
        }
    }

    @Test
    public void searchOverlapIn() {
        HashSet<Interval> overlappingInterval = (HashSet<Interval>) rangetree.overlapsAt(new Interval(16, 19));
        assertFalse((overlappingInterval).isEmpty());
        assertTrue(overlappingInterval.contains(new Interval(15, 20)));
        assertTrue(overlappingInterval.contains(new Interval(17, 19)));
        assertTrue(overlappingInterval.contains(new Interval(10, 30)));
    }
}