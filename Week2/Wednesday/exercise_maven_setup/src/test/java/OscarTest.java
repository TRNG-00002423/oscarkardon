import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.maven.setup.Oscar;

public class OscarTest {
    @Test
    void testOscar(){
        Oscar oscar = new Oscar();
        int actualResult = oscar.runOscar();
        int expectedResult = 99;
        Assertions.assertEquals(actualResult, expectedResult);
    }
}
