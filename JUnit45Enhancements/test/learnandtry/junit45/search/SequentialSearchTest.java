package learnandtry.junit45.search;

import junit.framework.TestCase;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class SequentialSearchTest extends TestCase {

    private SequentialSearch sequentialSearch = new SequentialSearch();

    @DataPoints
    public static Object[] testData() {
        return new Object[] {new Object[]{new int[] {0, 1, 2, 3, 4, 5}, 0, 0},
                             new Object[]{new int[] {0, 1, 2, 3, 4, 5}, 1, 1},
                             new Object[]{new int[] {2, 5, 10, 3, 4, 5}, 5, 1},
                             new Object[]{new int[] {2, 1, 10, 3, 4, 5}, 5, 5},
        };
    }

    @Theory
    public void search(Object[] testData) {
        int key = sequentialSearch.search((int[])testData[0], (Integer)testData[1]);
        assertEquals(testData[2], key);
    }

}
