package com.m0j0hn.assertionsRule;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;
import org.junit.Rule;

import com.m0j0hn.assertionsRule.Assertions;
import com.m0j0hn.assertionsRule.AssertionsRule;

/**
 * @author m0j0hn@users.noreply.github.com
 */
public class AssertionsRuleTestEnabledTrue {

    @Rule
    public AssertionsRule assertionsRule = new AssertionsRule().enabled(true);

    @Test
    public void testAssertionsRuleEnabledTrue_noAssertions() {
        System.out.println("testAssertionsRule_noAssertions");
        assertTrue(true);
    }

    @Assertions
    @Test
    public void testAssertionsRuleEnabledTrue_Assertions_noarg() {
        assumeTrue(true);
        System.out.println("testAssertionsRule_Assertions_noarg");
        assertTrue(true);
    }

    @Assertions(enabled=true)
    @Test
    public void testAssertionsRuleEnabledTrue_Assertions_enabledTrue() {
        System.out.println("testAssertionsRule_Assertions_enabledTrue");
        assertTrue(true);
    }

    @Assertions(enabled=false)
    @Test
    public void testAssertionsRuleEnabledTrue_Assertions_enabledFalse() {
        assumeTrue(true);
        System.out.println("testAssertionsRule_Assertions_enabledFalse");
        assertTrue(true);
    }
}
