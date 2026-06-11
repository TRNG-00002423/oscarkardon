package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreeterTest {
    @Test
    void testGreet(){
        Greeter greeter = new Greeter();
        String expectedResult = "Hello OSCAR";
        String actualResult = greeter.hello("Oscar");

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
