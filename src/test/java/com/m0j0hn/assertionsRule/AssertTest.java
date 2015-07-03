package com.m0j0hn.assertionsRule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * @author m0j0hn@users.noreply.github.com
 */
public class AssertTest {

    //DEFAULT: assertionsenabled is false unless enabled.
    boolean assertionsEnabled = false;

    @Before
    public void setUp() {
        //"assert" only runs if assertionsenabled is true
        assert assertionsEnabled = true;
    }

    @Test
    public void testAssert_assertionsEnabled() {
        //assumeTrue is a JUnit thing: only if true will this test not be ignored.
        //Therefore, only if assertionsEnabled is true will this test run.
        assumeTrue(assertionsEnabled);
        System.out.println("testAssert_assertionsEnabled");
        assertTrue(false);
    }

    @Test
    public void testAssert_true() {
        //assumeTrue(true) is *always* true,
        //therefore this test never ignored and will always run.
        assumeTrue(true);
        System.out.println("testAssert_true");
        assertTrue(true);
    }
}
