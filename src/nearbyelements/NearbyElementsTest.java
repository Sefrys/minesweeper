package nearbyelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 25.04.18, 23:38
 * Contact: sefrys@gmail.com
 */
class NearbyElementsTest {
    private NearbyElements ne = new NearbyElements();


    @Test
    void testNearby_1() {
        int[] actual = ne.nearby(0, 2, 2);
        int[] expected = new int[]{2, 0, 1241, 12};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testNearby_2() {
        int[] actual = ne.nearby(1, 0, 1);
        int[] expected = new int[]{3};
        assertArrayEquals(expected, actual);
    }
    @Test
    void testNearby_3() {
        int[] actual = ne.nearby(1, 3, 5);
        int[] expected = new int[]{1, 3, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testNearby_4() {
        int[] actual = ne.nearby(2, 5, 10);
        int[] expected = new int[]{ 321, 320, 32, 3, 41241, -12, -13, -66, -688 };
        assertArrayEquals(expected, actual);
    }

}