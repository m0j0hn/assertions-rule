package com.m0j0hn.assertionsRule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.junit.Assume;

import java.lang.annotation.Annotation;

import com.m0j0hn.assertionsRule.Assertions;

/**
 * @author m0j0hn@users.noreply.github.com
 */
public class AssertionsRule implements TestRule {

    boolean override = false;  //Is "enabled" specified via enabled() ?
    boolean enabled = false;

    /**
     * Convenience class to run tests or not depending on state of assert().
     */
    AssertionsRule() {}

    //Used to override command line "enableassertions" setting.
    //Intended to be used for testing the tests themselves.
    //Note that this subverts the assumeTrue() functionality. (???true???)
    //The boolean this.override is used to determine whether setting was specified.
    public AssertionsRule enabled(){
        this.override = true;
        this.enabled = true;
        return this;
    }

    public AssertionsRule enabled(boolean enabled){
        this.override = true;
        this.enabled = enabled;
        return this;
    }

    public Statement apply(final Statement base, final Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                boolean assertionsEnabled = false;  //DEFAULT

                System.err.println("enabled: " + enabled);

                //"assert" only evaluated if enableassertions is in effect.
                assert assertionsEnabled = true;

                //(Possibly) override assertionsEnabled with enabled override setting.
                //That is, regardless of the command line "enableassertions" or "-ea" settings,
                //by calling enabled() or enabled(true),
                //one can enable assertions in this test class.
                if (override) {
                    assertionsEnabled = enabled;
                }

                // Annotation handling:
                //Now, consider the annotations.
                //If annotation @Assertions is found,
                //then it (may) influence whether this test runs or not.
                Annotation annotation = description.getAnnotation(Assertions.class);

                if (null != annotation ) {
                    Assertions assertions = (Assertions) annotation;

                    System.err.println("Annotation : " + assertions.toString() );

                    assertionsEnabled = assertions.enabled();  //Override.
                }

                System.err.println("enabled: " + enabled);


                //assumeTrue ignores test unless true.
                Assume.assumeTrue(assertionsEnabled);

                //If we got this far, then run the test.
                base.evaluate();

            }
        };
    }
}
