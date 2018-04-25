package nearbyelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ireneusz Zagan on 25.04.18, 23:36
 * Contact: sefrys@gmail.com
 */
class NearbyElements {
    private int[][] multi = new int[][]{
            { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    int[] nearby(int xCoord, int yCoord, int range) {
        List<Integer> elems = new ArrayList<>();

        int[] row = multi[xCoord];
        for(int i = 0; i < yCoord && i <= range; i++) {
            if(i < row.length) elems.add(row[i]);
        }

        for(int y = yCoord + 1; y <= yCoord + range; y++) {
            if(y < row.length) elems.add(row[y]);

        }
        return elems.stream().mapToInt(Integer::intValue).toArray();
    }
}
