import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.StringUtils;


@DisplayName("Unit Tests for String Utils")
public class unitTests {
    private final StringUtils stringUtils = new StringUtils();

    @Test
    @DisplayName("Reverse Test")
    void testReverse(){
        assertEquals("olleh", stringUtils.reverse("hello"), "hello reverse is olleh");
        assertEquals("a", stringUtils.reverse("a"));
        assertEquals("", stringUtils.reverse(""));

    }

    @Test
    @DisplayName("isEmpty Test")
    void testIsEmpty(){
        assertTrue(stringUtils.isEmpty(""), "blank is empty");
        assertFalse(stringUtils.isEmpty("     "), "spaces is not empty");
        assertFalse(stringUtils.isEmpty("oscar"));
    }

    @Test
    @DisplayName("FindFirst Test")
    void testFindFirst(){
        assertNotNull(stringUtils.findFirst(new String[] {"a", "abc"}, "a"), "A found");
        assertNull(stringUtils.findFirst(new String[] {"a", "abc"}, "f"), "f not found");  
    }

    @Test
    @DisplayName("Split Test")
    void splitTest(){
        String[] expected = {"a", "b", "c"};
        String[] actual = StringUtils.split("a,b,c", ",");
        assertArrayEquals(expected, actual);
    }
}
